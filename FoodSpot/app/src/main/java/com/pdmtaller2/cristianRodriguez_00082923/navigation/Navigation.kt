package com.pdmtaller2.cristianRodriguez_00082923.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.cristianRodriguez_00082923.components.*
import com.pdmtaller2.cristianRodriguez_00082923.screen.*

@Composable
fun FoodSpotNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = HomeScreen,
            modifier = androidx.compose.ui.Modifier.padding(innerPadding)
        ) {
            composable<HomeScreen> {
                HomeScreen(onRestaurantClick = { restaurantId ->
                    navController.navigate(MenuScreen(restaurantId))
                })
            }
            composable<MenuScreen> { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
                MenuScreen(restaurantId)
            }
            composable<SearchScreen> {
                SearchScreen()
            }
            composable<OrdersScreen> {
                OrdersScreen()
            }
        }
    }
}
