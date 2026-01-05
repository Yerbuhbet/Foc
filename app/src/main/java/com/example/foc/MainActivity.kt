package com.example.foc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foc.data.local.AppDatabase
import com.example.foc.repository.TaskRepository
import com.example.foc.ui.home.HomeScreen
import com.example.foc.ui.home.PomodoroViewModel
import com.example.foc.ui.theme.FocTheme
import androidx.room.Room

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "foc-database"
        ).build()
        val repository = TaskRepository(db.taskDao())

        setContent {
            FocTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val viewModel: PomodoroViewModel = remember {
                        PomodoroViewModel(repository)
                    }

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}
