@file:Suppress("UNUSED_EXPRESSION")

package com.example.catalogocomposeandroide

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val courotineScope = rememberCoroutineScope()
    Scaffold(topBar = {
        MyTopAppBar {
            courotineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    "Has pulsado $it"
                )
            }
        }
    }, scaffoldState = scaffoldState, bottomBar = { MyBottomNavigation()}) {

    }
}


@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(title = { Text(text = "Mi primera toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("back") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("delete") }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "eliminar")
            }
        }
    )
}


@Composable
fun MyBottomNavigation() {
    var index by rememberSaveable { mutableStateOf(0) }
    BottomNavigation(backgroundColor = Color.Magenta, contentColor = Color.White) {
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text(text = "Home") },
            selected = index == 0,
            onClick = { index = 0 }
        )
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Fav") },
            label = { Text(text = "Fav") },
            selected = index == 1,
            onClick = { index = 1 }
        )
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Person") },
            label = { Text(text = "Person") },
            selected = index == 2,
            onClick = { index = 2 }
        )
    }
}