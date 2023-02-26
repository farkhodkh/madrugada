package ru.transitcard.madrugada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.navigation.compose.rememberNavController
import ru.transitcard.madrugada.navigation.BottomBarItem
import ru.transitcard.madrugada.navigation.BottomNavigationController
import ru.transitcard.madrugada.navigation.Navigation
import ru.transitcard.madrugada.navigation.Screens
import ru.transitcard.madrugada.ui.BottomNavWithBadgesTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavWithBadgesTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationController(
                            items = listOf(
                                BottomBarItem(
                                    name = "Основной",
                                    route = Screens.MainScreen.route,
                                    icon = Icons.Default.Home
                                ),
                                BottomBarItem(
                                    name = "Продажи",
                                    route = Screens.ShoppingChartScreen.route,
                                    icon = Icons.Default.ShoppingCart,
                                    badgeCount = 3
                                ),
                                BottomBarItem(
                                    name = "Настройки",
                                    route = Screens.SettingsScreen.route,
                                    icon = Icons.Default.Settings,
                                    badgeCount = 2
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}
