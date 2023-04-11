package com.example.catalogocomposeandroide.model

sealed class Routes(val route: String) {
    object ScreenOne : Routes("screen1")
    object ScreenTwo : Routes("screen2")
    object ScreenThree : Routes("screen3")
    object ScreenFour : Routes("screen4/{age}") {
        fun createRoute(age: Int) = "screen4/$age"
    }

    object ScreenFive : Routes("screen5/?name={name}") {
        fun createRoute(name: String) = "screen5/?name=$name"
    }
}
