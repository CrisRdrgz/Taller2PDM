package com.pdmtaller2.cristianRodriguez_00082923.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
data class MenuScreen(val restaurantId: Int)

@Serializable
object SearchScreen

@Serializable
object OrdersScreen
