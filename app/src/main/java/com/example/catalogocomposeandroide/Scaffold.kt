@file:Suppress("UNUSED_EXPRESSION")

package com.example.catalogocomposeandroide

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
    }, scaffoldState = scaffoldState) {

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
