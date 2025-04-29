package com.pdmtaller2.cristianRodriguez_00082923.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2.cristianRodriguez_00082923.RestaurantViewModel
import com.pdmtaller2.cristianRodriguez_00082923.components.Dish

@Composable
fun MenuScreen(
    restaurantId: Int,
    viewModel: RestaurantViewModel = viewModel()
) {
    val restaurant = viewModel.restaurants.find { it.id == restaurantId }
    val context = LocalContext.current

    if (restaurant == null) {
        Text(text = "No se encontro el restaurante")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = restaurant.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(restaurant.menu.size) { index ->
                DishItem(
                    dish = restaurant.menu[index],
                    onAddToCart = {
                        Toast.makeText(context, "${restaurant.menu[index].name} agregado al carrito", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Composable
fun DishItem(
    dish: Dish,
    onAddToCart: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(dish.imageURL),
            contentDescription = dish.name,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clickable { onAddToCart() },
            contentScale = ContentScale.Crop
        )
        Text(
            text = dish.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = dish.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Button(
            onClick = { onAddToCart() },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Agregar al carrito")
        }
    }
}
