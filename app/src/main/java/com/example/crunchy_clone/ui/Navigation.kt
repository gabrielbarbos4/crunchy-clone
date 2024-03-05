package com.example.crunchy_clone.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crunchy_clone.ui.screens.on_board.OnBoard

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "onBoard") {
        composable("onBoard") {
            OnBoard()
        }
    }
}
