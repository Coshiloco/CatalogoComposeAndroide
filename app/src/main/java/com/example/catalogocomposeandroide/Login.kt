package com.example.catalogocomposeandroide

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun logineador() {


    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (usuario, password) = createRefs()

        TextField(modifier = Modifier.constrainAs(usuario){
           top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }, value = "holas", onValueChange = {

        })

    }

}