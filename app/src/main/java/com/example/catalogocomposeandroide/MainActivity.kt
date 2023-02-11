package com.example.catalogocomposeandroide

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
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
/*                    var myText by rememberSaveable { mutableStateOf("Pablo")}

                    MyTextFieldState(myText) {
                        myText = it
                    }*/
/*                    var myOptions = getOptions(titles = listOf(
                        "Aris",
                        "Ejemplo",
                        "Pablo",
                        "MacDonalls",
                        "De locos",
                        "Que cojones"
                    ))
                    Column {
                        myOptions.forEach {
                            MyTextBoxWithTextCompleted(it)
                        }
                    }*/
                    MyTrisStatusCheckBox()
                }
            }
        }
    }
}


@Composable
fun MyTrisStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off)}
    TriStateCheckbox(state = status, onClick = {
        status = when(status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { mynewStatus ->
                status = mynewStatus
            }
        )
    }
}


@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = !enabled },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Green,
                disabledContentColor = Color.Red
            ),
            border = BorderStroke(
                5.dp,
                Color.Green
            )
        ) {
            Text(text = "hola")
        }
        OutlinedButton(
            onClick = { enabled = !enabled },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Green,
                disabledContentColor = Color.Red
            )
        ) {
            Text(text = "Outlined Button hola")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Soy un text button")
        }
    }
}


@Composable
fun MyTextBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(modifier = Modifier.padding(8.dp)) {
        Checkbox(checked = checkInfo.selected, onCheckedChange = {
            checkInfo.onCheckedChange(!checkInfo.selected)
        })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyTextBoxWithText() {
    var checkCheckedBox by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Checkbox(checked = checkCheckedBox, onCheckedChange = {
            checkCheckedBox = !checkCheckedBox
        })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo Uno")
    }
}

@Composable
fun MyCheckBox() {
    var marcadorCheckBoxes by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = marcadorCheckBoxes, onCheckedChange = {
            marcadorCheckBoxes = !marcadorCheckBoxes
        },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MySwitch() {
    var stateswitchbar by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = stateswitchbar, onCheckedChange = {
            stateswitchbar = !stateswitchbar
        },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.5f,
            uncheckedTrackAlpha = 0.3f,
            disabledCheckedThumbColor = Color.LightGray,
            disabledCheckedTrackColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.White,
            disabledUncheckedTrackColor = Color.Gray
        )
    )
}


@Composable
fun MyProgressAdvance() {

    var controlProgress by rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            progress = controlProgress,
            color = Color.Red,
            strokeWidth = 10.dp
        )

        LinearProgressIndicator(
            modifier = Modifier.padding(top = 32.dp),
            progress = controlProgress,
            color = Color.Red,
            backgroundColor = Color.Green
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            OutlinedButton(onClick = { controlProgress += 0.1f }) {
                Text(text = "Incrementar progress bar")
            }
            OutlinedButton(onClick = { controlProgress -= 0.1f }) {
                Text(text = "Decrementar progress bar")
            }
        }
    }
}

@Composable
fun MyProgressbar() {

    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                backgroundColor = Color.Green
            )
        }
        OutlinedButton(
            modifier = Modifier.padding(15.dp),
            onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar perfil")
        }
    }
}


@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "IconoEjemplo",
        tint = Color.Red
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier.clip(RoundedCornerShape(25f))
    )
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(
                5.dp,
                Color.Red,
                CircleShape
            )
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")
    }
}


@Composable
fun MyTexFieldOUtLined() {
    var MyText by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = MyText,
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Holita") },
        onValueChange = { MyText = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}


@Composable
fun myTextFieldAdvance() {
    var mytext by rememberSaveable { mutableStateOf("") }
    TextField(value = mytext, onValueChange = {
        mytext = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    },
        label = { Text(text = "Introduce tu nombre") })
}


@Composable
fun MyTextFieldComponent() {
    var myText by rememberSaveable { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyTextFieldState(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}


@Composable
fun MyTextComponent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 15.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatalogoComposeAndroideTheme {
/*        var myText by rememberSaveable { mutableStateOf("Pablo")}

        MyTextFieldState(myText) {
            myText = it
        }*/
        MyTrisStatusCheckBox()
    }
}