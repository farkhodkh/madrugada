package ru.transitcard.madrugada.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationController() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(
            route = Screens.MainScreen.route
        ) {
            HomeScreen(onClickListener = { screen ->
                navController.navigate(screen)
            })
        }

        composable(Screens.ShoppingChartScreen.route) { backStackEntry ->
            HomeScreen(onClickListener = { screen ->
                navController.navigate(screen)
            })
        }
    }
}