package com.example.catalogocomposeandroide

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

@Composable
fun BasicSlider() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MyAdvanceSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderposition by rememberSaveable { mutableStateOf(0) }
        var completeValue by rememberSaveable { mutableStateOf(0) }
        Slider(
            value = sliderposition.toFloat(), onValueChange = { sliderposition = it.toInt() },
            onValueChangeFinished = { completeValue = sliderposition },
            valueRange = 0f..100f
        )
        Text(text = completeValue.toString())
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        var currentRange by rememberSaveable { mutableStateOf(0..100) }

        RangeSlider(
            values = currentRange.first.toFloat()..currentRange.last.toFloat(),
            onValueChange = { currentRange = it.start.toInt()..it.endInclusive.toInt() },
            valueRange = 0f..40f
        )
        
        Text(text = "Valor inferior ${currentRange.first}")
        Text(text = "Valor superior ${currentRange.last}")
    }
}

