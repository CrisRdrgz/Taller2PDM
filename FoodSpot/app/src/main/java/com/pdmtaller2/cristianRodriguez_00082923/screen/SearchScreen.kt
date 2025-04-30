package com.pdmtaller2.cristianRodriguez_00082923.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdmtaller2.cristianRodriguez_00082923.RestaurantViewModel
import com.pdmtaller2.cristianRodriguez_00082923.components.SearchRestaurant

@Composable
fun SearchScreen(onRestaurantClick: (Int) -> Unit) {
    val viewModel = remember { RestaurantViewModel() }
    var query by remember { mutableStateOf("") }

    val matched = remember(query) {
        if (query.isBlank()) emptyList()
        else viewModel.restaurants.filter { restaurant ->
            restaurant.name.contains(query, ignoreCase = true) ||
                    restaurant.categories.any { it.contains(query, ignoreCase = true) } ||
                    restaurant.menu.any { it.name.contains(query, ignoreCase = true) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Buscar restaurantes",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = query,
            onValueChange = { query = it },
            singleLine = true,
            label = { Text("Escribe un nombre o categoria") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (matched.isEmpty()) {
            Text(
                text = "Sin resultados",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                matched.forEach { restaurant ->
                    SearchRestaurant(restaurant = restaurant, onRestaurantCardClick = onRestaurantClick)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}
