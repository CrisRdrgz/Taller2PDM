package com.pdmtaller2.cristianRodriguez_00082923.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.cristianRodriguez_00082923.navigation.*
import com.pdmtaller2.cristianRodriguez_00082923.screen.*

enum class NavSection {
    MAIN, MENU, FIND, ORDERS, MENU_FROM_SEARCH
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLayout() {
    val navController = rememberNavController()
    var current by remember { mutableStateOf(NavSection.MAIN) }

    val goToHome = {
        current = NavSection.MAIN
        navController.navigate(HomeScreen)
    }
    val goToSearch = {
        current = NavSection.FIND
        navController.navigate(SearchScreen)
    }
    val goToOrders = {
        current = NavSection.ORDERS
        navController.navigate(OrdersScreen)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FoodSpot") },
                navigationIcon = {
                    if (current == NavSection.MENU || current == NavSection.MENU_FROM_SEARCH) {
                        IconButton(onClick = {
                            current = if (current == NavSection.MENU) NavSection.MAIN else NavSection.FIND
                            navController.popBackStack()
                        }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF64c9a7),
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF64c9a7)) {
                NavigationBarItem(
                    selected = current == NavSection.MAIN,
                    onClick = goToHome,
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Restaurantes") }
                )
                NavigationBarItem(
                    selected = current == NavSection.FIND,
                    onClick = goToSearch,
                    icon = { Icon(Icons.Default.Search, contentDescription = null) },
                    label = { Text("Buscar") }
                )
                NavigationBarItem(
                    selected = current == NavSection.ORDERS,
                    onClick = goToOrders,
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                    label = { Text("Órdenes") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            NavHost(navController = navController, startDestination = HomeScreen) {
                composable<HomeScreen> {
                    val onRestaurantClick = { id: Int ->
                        current = NavSection.MENU
                        navController.navigate(MenuScreen(id))
                    }
                    HomeScreen(onRestaurantClick = onRestaurantClick)

                }
                composable<MenuScreen> { backStack ->
                    val id = backStack.arguments?.getInt("id") ?: 0
                    MenuScreen(restaurantId = id)
                }
                composable<SearchScreen> {
                    val onRestaurantClick = { id: Int ->
                        current = NavSection.MENU_FROM_SEARCH
                        navController.navigate(MenuScreen(id))
                    }
                    SearchScreen(onRestaurantClick = onRestaurantClick)
                }
                composable<OrdersScreen> {
                    OrdersScreen()
                }
            }
        }
    }
}
