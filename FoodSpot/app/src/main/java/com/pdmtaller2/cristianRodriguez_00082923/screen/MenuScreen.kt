package com.pdmtaller2.cristianRodriguez_00082923.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdmtaller2.cristianRodriguez_00082923.RestaurantViewModel
import com.pdmtaller2.cristianRodriguez_00082923.components.DishItem

@Composable
fun MenuScreen(restaurantId: Int) {
    val restaurant = RestaurantViewModel().restaurants.find { it.id == restaurantId }
    var query by remember { mutableStateOf("") }

    val filteredMenu = remember(restaurant, query) {
        if (query.isBlank()) {
            restaurant?.menu
        } else {
            restaurant?.menu?.filter { it.name.contains(query, ignoreCase = true) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = restaurant?.name ?: "Restaurante no encontrado",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = restaurant?.description ?: "",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar plato") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxSize()) {
            filteredMenu?.forEach { dish ->
                DishItem(dish)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
