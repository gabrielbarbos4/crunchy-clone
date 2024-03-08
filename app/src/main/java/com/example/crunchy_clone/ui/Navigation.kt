package com.example.crunchy_clone.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.crunchy_clone.ui.screens.auth.login.Login
import com.example.crunchy_clone.ui.screens.auth.register.Register
import com.example.crunchy_clone.ui.screens.home.HomeScreen
import com.example.crunchy_clone.ui.screens.on_board.OnBoard
import com.example.crunchy_clone.ui.theme.Orange400
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.crunchy_clone.ui.screens.account.AccountScreen
import com.example.crunchy_clone.ui.screens.catalog.CatalogScreen
import com.example.crunchy_clone.ui.screens.list.ListScreen
import com.example.crunchy_clone.ui.screens.simulcasts.SimulcastsScreen

enum class PublicRoutes {
    OnBoard,
    Login,
    Register,
}

enum class AppRoutes {
    App,
    Home,
    Lists,
    Catalog,
    Simulcasts,
    Account
}

val enabledNavigationBarRoutes = AppRoutes.values().map { it.name };

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val route by navController.currentBackStackEntryAsState()
    val currentRoute = route?.destination?.route

    Scaffold(
        bottomBar = {
            if (enabledNavigationBarRoutes.contains(currentRoute)) {
                BottomNavigation {
                    val a = intArrayOf(1,2,3,4,5)
                    a.forEach { item ->
                        BottomNavigationItem(
                            selected = item == 1,
                            onClick = { /*TODO*/ },
                            icon = { Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Orange400 ) }
                        )
                    }
                }
            }
        },
    ) {
        innerPaddingModifier -> AppNavHost(
            navController = navController,
            Modifier.padding(innerPaddingModifier)
        )
    }
}

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = PublicRoutes.OnBoard.name,
        modifier = modifier
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
            Login(
                onLoginButtonClick = { navController.navigate(AppRoutes.App.name) }
            )
        }
        navigation(startDestination = AppRoutes.Home.name, route = AppRoutes.App.name) {
            composable(AppRoutes.Home.name) {
                HomeScreen()
            }
            composable(AppRoutes.Lists.name) {
                ListScreen()
            }
            composable(AppRoutes.Catalog.name) {
                CatalogScreen()
            }
            composable(AppRoutes.Simulcasts.name) {
                SimulcastsScreen()
            }
            composable(AppRoutes.Account.name) {
                AccountScreen()
            }
        }
    }
}
