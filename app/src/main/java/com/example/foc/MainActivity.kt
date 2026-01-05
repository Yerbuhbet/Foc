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

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.example.foc.data.preferences.DataStoreManager
import com.example.foc.ui.onboarding.OnboardingScreen
import com.example.foc.ui.onboarding.SplashScreen
import com.example.foc.ui.onboarding.WelcomeScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "foc-database"
        ).build()
        val repository = TaskRepository(db.taskDao())
        val dataStoreManager = DataStoreManager(applicationContext)

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
                    val scope = rememberCoroutineScope()
                    val onboardingCompleted by dataStoreManager.isOnboardingCompleted.collectAsState(initial = null)

                    if (onboardingCompleted != null) {
                        NavHost(
                            navController = navController,
                            startDestination = "splash"
                        ) {
                            composable("splash") {
                                SplashScreen(onTimeout = {
                                    if (onboardingCompleted == true) {
                                        navController.navigate("home") {
                                            popUpTo("splash") { inclusive = true }
                                        }
                                    } else {
                                        navController.navigate("onboarding") {
                                            popUpTo("splash") { inclusive = true }
                                        }
                                    }
                                })
                            }
                            composable("onboarding") {
                                OnboardingScreen(
                                    onFinished = {
                                        scope.launch {
                                            dataStoreManager.setOnboardingCompleted(true)
                                            navController.navigate("welcome") {
                                                popUpTo("onboarding") { inclusive = true }
                                            }
                                        }
                                    },
                                    onSkip = {
                                        scope.launch {
                                            dataStoreManager.setOnboardingCompleted(true)
                                            navController.navigate("welcome") {
                                                popUpTo("onboarding") { inclusive = true }
                                            }
                                        }
                                    }
                                )
                            }
                            composable("welcome") {
                                WelcomeScreen(
                                    onSignUp = { /* TODO */ },
                                    onLogin = { /* TODO */ },
                                    onGoogleContinue = { /* TODO */ },
                                    onFacebookContinue = { /* TODO */ },
                                    onTwitterContinue = { /* TODO */ }
                                )
                            }
                            composable("home") {
                                HomeScreen(viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}
