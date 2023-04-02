package com.example.catalogocomposeandroide

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecycleerview() {
    val mylist = listOf("Pepe", "Manolin", "Oscarin", "Pedrin", "Cajoncin", "Melocotonin")
    LazyColumn {
        item { Text(text = "Primer item") }
        items(count = 7){
            Text(text = "Este es el item $it")
        }
        items(mylist) {
            Text(text = "Hola me llamo $it")
        }
    }
}