package com.example.mytestapplication001.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytestapplication001.presentation.welcome.WelcomeScreenState

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.WELCOME_ROUTE
    ) {
        composable(Destination.WELCOME_ROUTE) {
            WelcomeScreenState()
        }
    }
}