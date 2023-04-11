package com.example.catalogocomposeandroide

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.catalogocomposeandroide.model.Routes


@Composable
fun ScreenOne(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Screen One",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenTwo.route) })
    }
}


@Composable
fun ScreenTwo(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Screen One",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenThree.route) })
    }
}

@Composable
fun ScreenThree(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Screen One",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenFour.createRoute(22)) })
    }
}


@Composable
fun ScreenFour(navigationController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Tengo $age años",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenFive.createRoute("Pablo")) })
    }
}


@Composable
fun ScreenFive(navigationController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Me llamo $name",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenOne.route) })
    }
}