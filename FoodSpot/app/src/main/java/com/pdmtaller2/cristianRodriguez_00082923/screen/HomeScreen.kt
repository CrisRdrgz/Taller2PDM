package com.pdmtaller2.cristianRodriguez_00082923.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
fun HomeScreen(
    viewModel: RestaurantViewModel = viewModel(),
    onRestaurantClick: (Int) -> Unit
) {
    val restaurants = viewModel.restaurants

    val categories = remember {
        restaurants.flatMap { it.categories }.distinct()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
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
                        RestaurantCard(
                            restaurant = filteredRestaurants[index],
                            onClick = { onRestaurantClick(filteredRestaurants[index].id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(end = 8.dp)
            .width(180.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = rememberAsyncImagePainter(restaurant.imageURL),
            contentDescription = restaurant.name,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
