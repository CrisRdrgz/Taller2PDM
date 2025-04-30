package com.pdmtaller2.cristianRodriguez_00082923

import androidx.lifecycle.ViewModel
import com.pdmtaller2.cristianRodriguez_00082923.data.Dish
import com.pdmtaller2.cristianRodriguez_00082923.data.Restaurant

class RestaurantViewModel : ViewModel() {

    val restaurants = listOf(
        Restaurant(
            id = 1,
            name = "Burguerson",
            description = "Las mejores hamburguesas rápidas.",
            imageURL = "https://th.bing.com/th/id/R.b002d1fd67ec16fd56c2682020bb0b79?rik=ubV30ffVVvT7oA&pid=ImgRaw&r=0",
            categories = listOf("Comida Rápida"),
            menu = listOf(
                Dish(
                    id = 1,
                    name = "Hamburguesa Clasica",
                    imageURL = "https://smartremo.es/wp-content/uploads/2020/04/hamburguesa-scaled.jpg",
                    description = "Carne, lechuga y tomate"
                ),
                Dish(
                    id = 2,
                    name = "Cheeseburger",
                    description = "Hamburguesa con queso",
                    imageURL = "https://thafd.bing.com/th/id/OIP.KX26QmhTY2kLCeSS5GMeIgHaE8?rs=1&pid=ImgDetMain"
                )
            )
        ),
        Restaurant(
            id = 2,
            name = "Taco dorado",
            description = "Tacos mexicanos",
            imageURL = "https://thafd.bing.com/th/id/OIP.8G2QisogCPERQKl2OyZrcQHaHa?rs=1&pid=ImgDetMain",
            categories = listOf("Comida Mexicana"),
            menu = listOf(
                Dish(
                    id = 3,
                    name = "al Pastor",
                    description = "Con piña y carne adobada",
                    imageURL = "https://thafd.bing.com/th/id/OIP.vfmuzfWMayBLsVZKX5dhMAHaLH?rs=1&pid=ImgDetMain"
                ),
                Dish(
                    id = 4,
                    name = "de Asada",
                    description = "Carne asada y cebolla",
                    imageURL = "https://th.bing.com/th/id/R.5c76b97473ba7ae1ef9ba34df9ff15bb?rik=QjM2lGpcgyfW6Q&pid=ImgRaw&r=0"
                )
            )
        ),
        Restaurant(
            id = 3,
            name = "Pasta Distrito Italia",
            description = "Comida italiana auténtica",
            imageURL = "https://thafd.bing.com/th/id/OIP.3mNTWboxOABuK9dhh4OGQgHaHa?rs=1&pid=ImgDetMain",
            categories = listOf("Comida Italiana"),
            menu = listOf(
                Dish(
                    id = 5,
                    name = "Spaghetti ",
                    description = "Pasta con salsa",
                    imageURL = "https://thafd.bing.com/th/id/OIP.cBD2qJoLGoClQkOxi2jb4QHaE6?rs=1&pid=ImgDetMain"
                ),
                Dish(
                    id = 6,
                    name = "Lasagna",
                    description = "pasta, carne y queso",
                    imageURL = "https://th.bing.com/th/id/R.0c619396699389e819f430f63b43bcf0?rik=hGEL4TBA4m%2b%2f2w&pid=ImgRaw&r=0"
                )
            )
        )
    )
}
