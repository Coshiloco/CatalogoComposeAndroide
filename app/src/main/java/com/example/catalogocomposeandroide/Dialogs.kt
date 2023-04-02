package com.example.catalogocomposeandroide

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties



@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDissmis: () -> Unit
) {
    if(show) {
        Dialog(onDismissRequest = { onDissmis() }) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)) {
                MyTitleDialog(text = "Phone Ringtone", modifier = Modifier.padding(24.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                var status by rememberSaveable { mutableStateOf("")}
                MyRadioButtonList(name = status, onItemSelected = {status = it})
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(modifier = Modifier.align(Alignment.End).padding(12.dp)) {
                    OutlinedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Cancel")
                    }
                    OutlinedButton(onClick = { /*TODO*/ }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}



@Composable
fun MyCustomDialog(
    show: Boolean,
    onDissmis: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDissmis() }) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(email = "penelargo@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "holabuenastardes@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "holasoypersonalizado@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun AccountItem(email:String, @DrawableRes drawable:Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyTitleDialog(text:String, modifier: Modifier = Modifier.padding(12.dp)) {
    Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 20.sp,
        modifier = modifier
        )
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDissmis: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
            ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
                Text(text = "pene")
                Text(text = "mazorca")
            }
        }
    }
}


@Composable
fun MyAlertDialog(show:Boolean,
                Ondismiss:() -> Unit,
                  Onconfirm:() -> Unit
                  ) {
    if(show) {
        AlertDialog(onDismissRequest = { Ondismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Chachi piruli descripcion") },
            confirmButton = {
                OutlinedButton(onClick = { Onconfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { Ondismiss() }) {
                    Text(text = "DissmissButton")
                }
            }
        )
    }
}