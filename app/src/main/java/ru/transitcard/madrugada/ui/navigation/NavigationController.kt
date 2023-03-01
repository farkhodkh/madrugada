package ru.transitcard.madrugada.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.transitcard.madrugada.mainscreen.ui.MainScreen
import ru.transitcard.madrugada.ui.views.ShoppingChartScreen

@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {

        composable(
            route = Screens.MainScreen.route
        ) {
            MainScreen(onClickListener = { screen ->
                navController.navigate(screen)
            })
        }

        composable(Screens.SettingsScreen.route) {
            SettingsScreen(onClickListener = { screen ->
                navController.navigate(screen)
            })
        }

        composable(Screens.ShoppingChartScreen.route) {
            ShoppingChartScreen(onClickListener = { screen ->
                navController.navigate(screen)
            })
        }

    }
}