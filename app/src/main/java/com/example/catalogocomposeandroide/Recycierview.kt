package com.example.catalogocomposeandroide

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catalogocomposeandroide.model.SuperHero

@Composable
fun SimpleRecycleerview() {
    val mylist = listOf("Pepe", "Manolin", "Oscarin", "Pedrin", "Cajoncin", "Melocotonin")
    LazyColumn {
        item { Text(text = "Primer item") }
        items(count = 7) {
            Text(text = "Este es el item $it")
        }
        items(mylist) {
            Text(text = "Hola me llamo $it")
        }
    }
}


@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(getSuperheroes()) { superhero ->
            ItemHero(superHero = superhero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(10.dp),
                fontSize = 10.sp
            )
        }
    }
}


fun getSuperheroes(): List<SuperHero> {
    return listOf(
        SuperHero(
            "batman",
            "JAmes batman",
            "batmicon",
            R.drawable.batman
        ),
        SuperHero(
            "daredevil",
            "JAmes daredevil",
            "daredevilicon",
            R.drawable.daredevil
        ),
        SuperHero(
            "flash",
            "JAmes flashun",
            "flashicon",
            R.drawable.flash
        ),
        SuperHero(
            "Green linterna",
            "JAmes linterna",
            "lintercomicon",
            R.drawable.green_lantern
        ),
        SuperHero(
            "logan",
            "JAmes logan",
            "logamicon",
            R.drawable.logan
        ),
        SuperHero(
            "spiderman",
            "JAmes spiderman",
            "spidermicon",
            R.drawable.spiderman
        ),
        SuperHero(
            "thor",
            "JAmes thor",
            "thormicon",
            R.drawable.thor
        ),
        SuperHero(
            "wonder woman",
            "JAmes woman",
            "wondermicon",
            R.drawable.wonder_woman
        )
    )
}