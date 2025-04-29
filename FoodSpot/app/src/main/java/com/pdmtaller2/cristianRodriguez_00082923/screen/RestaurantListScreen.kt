package com.pdmtaller2.cristianRodriguez_00082923.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2.cristianRodriguez_00082923.RestaurantViewModel
import com.pdmtaller2.cristianRodriguez_00082923.components.Restaurant

@Composable
fun RestaurantListScreen(
    viewModel: RestaurantViewModel = viewModel()
) {
    val restaurants = viewModel.restaurants

    // Agrupar por categorías
    val categories = remember {
        restaurants.flatMap { it.categories }.distinct()
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        categories.forEach { category ->
            item {
                Text(
                    text = category,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                val filteredRestaurants = restaurants.filter { it.categories.contains(category) }

                LazyRow {
                    items(filteredRestaurants.size) { index ->
                        RestaurantCard(filteredRestaurants[index])
                    }
                }
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant) {
    Column(
        modifier = Modifier
            .padding(end = 8.dp)
            .width(200.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(restaurant.imageURL),
            contentDescription = restaurant.name,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(text = restaurant.name, style = MaterialTheme.typography.bodyLarge)
    }
}
