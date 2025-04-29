package com.pdmtaller2.cristianRodriguez_00082923.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pdmtaller2.cristianRodriguez_00082923.navigation.*

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val destination: Any
)

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Restaurantes", Icons.Default.List, HomeScreen),
        BottomNavItem("Buscar", Icons.Default.Search, SearchScreen),
        BottomNavItem("Órdenes", Icons.Default.ShoppingCart, OrdersScreen)
    )

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentDestination == item.destination.toString(),
                onClick = {
                    navController.navigate(item.destination) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
