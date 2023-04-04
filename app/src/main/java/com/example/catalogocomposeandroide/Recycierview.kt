package com.example.catalogocomposeandroide

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catalogocomposeandroide.model.SuperHero
import kotlinx.coroutines.launch

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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superhero: Map<String, List<SuperHero>> = getSuperheroes().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        superhero.forEach { (publisher, mysuperheroes) ->
            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray),
                    fontSize = 20.sp
                )
            }
            items(mysuperheroes) { superhero ->
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
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
fun SuperHeroWithView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val courotineScope = rememberCoroutineScope()
    Column() {
        LazyColumn(
            state = rvState, verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(getSuperheroes()) { superhero ->
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showbutton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        rvState.firstVisibleItemScrollOffset
        if (showbutton) {
            OutlinedButton(
                onClick = {
                    courotineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp)
            ) {
                Text(text = "Soy el boton mas cool")
            }
        }
    }
}


@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperheroes()) { superhero ->
            ItemHero(superHero = superhero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }, contentPadding = PaddingValues(horizontal = 10.dp, vertical = 18.dp))
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }
            .padding(top = 10.dp, bottom = 10.dp, end = 20.dp, start = 20.dp)
    ) {
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