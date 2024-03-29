@file:Suppress("UNUSED_EXPRESSION")

package com.example.catalogocomposeandroide

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
    Scaffold(
        topBar = {
            MyTopAppBar(onClickIcon = {
                courotineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Has pulsado $it"
                    )
                }
            }, onClickDrawer = {
                courotineScope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFAB() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = {
            MyDrawer {
                courotineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        }
    ) {

    }
}


@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(title = { Text(text = "Mi primera toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("back") }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
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
            icon = { Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu") },
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


@Composable
fun MyFAB() {
    var show by rememberSaveable { mutableStateOf(false) }
    FloatingActionButton(onClick = { show = true }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
    if (show) {
        MyConfirmationDialog(show = show, onDissmis = { show = false })
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "Primera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Segunda opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Tercera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Cuarta opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickable { onCloseDrawer() }
        )
    }
}