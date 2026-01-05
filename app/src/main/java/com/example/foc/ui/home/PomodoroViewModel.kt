package com.example.foc.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foc.model.Task
import com.example.foc.repository.TaskRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class PomodoroUiState(
    val timeLeft: Long = 25 * 60 * 1000L,
    val isRunning: Boolean = false,
    val selectedTask: Task? = null,
    val tasks: List<Task> = emptyList(),
    val progress: Float = 1f
)

class PomodoroViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(PomodoroUiState())
    val uiState: StateFlow<PomodoroUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null
    private val totalTime = 25 * 60 * 1000L

    init {
        viewModelScope.launch {
            repository.allTasks.collect { tasks ->
                _uiState.update { it.copy(tasks = tasks) }
            }
        }
    }

    fun selectTask(task: Task?) {
        _uiState.update { it.copy(selectedTask = task) }
    }

    fun toggleTimer() {
        if (_uiState.value.isRunning) {
            pauseTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        _uiState.update { it.copy(isRunning = true) }
        timerJob = viewModelScope.launch {
            while (_uiState.value.timeLeft > 0) {
                delay(1000L)
                _uiState.update {
                    val newTime = it.timeLeft - 1000L
                    it.copy(
                        timeLeft = newTime,
                        progress = newTime.toFloat() / totalTime
                    )
                }
            }
            _uiState.update { it.copy(isRunning = false, timeLeft = totalTime, progress = 1f) }
        }
    }

    private fun pauseTimer() {
        timerJob?.cancel()
        _uiState.update { it.copy(isRunning = false) }
    }

    fun resetTimer() {
        pauseTimer()
        _uiState.update { it.copy(timeLeft = totalTime, progress = 1f) }
    }
}
