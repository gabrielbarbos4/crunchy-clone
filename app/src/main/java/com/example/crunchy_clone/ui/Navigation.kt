package com.example.crunchy_clone.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.crunchy_clone.ui.screens.account.AccountScreen
import com.example.crunchy_clone.ui.screens.catalog.CatalogScreen
import com.example.crunchy_clone.ui.screens.list.ListScreen
import com.example.crunchy_clone.ui.screens.simulcasts.SimulcastsScreen
import com.example.crunchy_clone.ui.theme.Neutral100
import com.example.crunchy_clone.ui.theme.Neutral900
import com.example.crunchy_clone.ui.theme.Typography

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

enum class CrunchyBottomNavigationOption(
    val label: String,
    val route: String,
    val icon: ImageVector
) {
    HOME(
        "Start",
        route = AppRoutes.Home.name,
        icon = Icons.Outlined.Home
    ),
    LIST(
        "Lists",
        route = AppRoutes.Lists.name,
        icon = Icons.Outlined.List
    ),
    CATALOG(
    "Catalog",
        route = AppRoutes.Catalog.name,
        icon = Icons.Outlined.Menu
    ),
    SIMULCATS(
    "Simulcasts",
        route = AppRoutes.Simulcasts.name,
        icon = Icons.Outlined.PlayArrow
    ),
    ACCOUNT(
        "Account",
        route = AppRoutes.Account.name,
        icon = Icons.Outlined.Settings
    )
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
                val items: Array<CrunchyBottomNavigationOption> = CrunchyBottomNavigationOption.values()
                BottomNavigation(
                    backgroundColor = Neutral900
                ) {
                    items.forEach { item ->
                        val itemColor = if(currentRoute == item.route) Orange400 else Neutral100

                        BottomNavigationItem(
                            selected = currentRoute == item.route,
                            onClick = { navController.navigate(item.route) },
                            label = {
                                Text(
                                    text = item.label,
                                    fontSize = Typography.labelSmall.fontSize,
                                    color = itemColor
                                )
                            },
                            icon = {
                                Icon(
                                    item.icon,
                                    contentDescription = item.label,
                                    tint = itemColor
                                )
                            }
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
fun CrunchyBottomNavigationBar(
    selected: Boolean = false
) {

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
