package com.example.catalogocomposeandroide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catalogocomposeandroide.ui.theme.CatalogoComposeAndroideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogoComposeAndroideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var myText by rememberSaveable { mutableStateOf("Pablo")}

                    MyTextFieldState(myText) {
                        myText = it
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable { mutableStateOf(0)}

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter +=1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")
    }
}


@Composable
fun MyTexFieldOUtLined() {
    var MyText by rememberSaveable { mutableStateOf("")}

    OutlinedTextField(value = MyText,
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Holita")},
        onValueChange = {MyText = it},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        ))
}


@Composable
fun myTextFieldAdvance() {
    var mytext by rememberSaveable { mutableStateOf("")}
    TextField(value = mytext, onValueChange = {
         mytext = if(it.contains("a")) {
             it.replace("a", "")
         } else {
             it
         }
    },
    label = { Text(text = "Introduce tu nombre")})
}


@Composable
fun MyTextFieldComponent() {
    var myText by rememberSaveable { mutableStateOf("")}
    TextField(value = myText, onValueChange = {myText = it})
}

@Composable
fun MyTextFieldState(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = {onValueChanged(it)})
}


@Composable
fun MyTextComponent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.combine(
            listOf(TextDecoration.LineThrough, TextDecoration.Underline))))
        Text(text = "Esto es un ejemplo", fontSize = 15.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatalogoComposeAndroideTheme {
        var myText by rememberSaveable { mutableStateOf("Pablo")}

        MyTextFieldState(myText) {
            myText = it
        }
    }
}