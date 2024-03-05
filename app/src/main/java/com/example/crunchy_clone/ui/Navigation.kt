package com.example.crunchy_clone.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crunchy_clone.ui.screens.auth.login.Login
import com.example.crunchy_clone.ui.screens.auth.register.Register
import com.example.crunchy_clone.ui.screens.on_board.OnBoard

enum class PublicRoutes {
    OnBoard,
    Login,
    Register
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PublicRoutes.OnBoard.name
    ) {
        composable(PublicRoutes.OnBoard.name) {
            OnBoard(
                onRegisterButtonClick = { navController.navigate(PublicRoutes.Register.name) },
                onLoginButtonClick = { navController.navigate(PublicRoutes.Login.name) }
            )
        }
        composable(PublicRoutes.Register.name) {
            Register()
        }
        composable(PublicRoutes.Login.name) {
            Login()
        }
    }
}
