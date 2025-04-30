package com.pdmtaller2.cristianRodriguez_00082923.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdmtaller2.cristianRodriguez_00082923.screen.*
import kotlinx.serialization.Serializable

@Composable
fun FoodSpotNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen> {
            HomeScreen(onRestaurantClick = { restaurantId ->
                navController.navigate(MenuScreen(restaurantId))
            })
        }

        composable<MenuScreen> { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: 0
            MenuScreen(
                restaurantId = restaurantId,
                onBack = { navController.popBackStack() }
            )
        }

        composable<SearchScreen> {
            SearchScreen(onRestaurantClick = { restaurantId ->
                navController.navigate(MenuScreen(restaurantId))
            })
        }

        composable<OrdersScreen> {
            OrdersScreen()
        }
    }
}
