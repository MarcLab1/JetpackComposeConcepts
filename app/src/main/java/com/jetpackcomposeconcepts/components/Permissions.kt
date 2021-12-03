package com.jetpackcomposeconcepts.components


import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun Permissions() {

    var permissionString by remember {
        mutableStateOf("")
    }
    var buttonClick by remember {
        mutableStateOf(false)
    }
    var ctx = LocalContext.current

    Column()
    {
        Text(text = permissionString)

        Button(onClick = { buttonClick = true }) {

            Text(text = "Button 1")
        }
    }

    if (buttonClick)
        buttonClicked()

}

@Composable
fun makeToast(msg: String) {
    var ctx = LocalContext.current
    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
}

@Composable
fun buttonClicked() {
    makeToast(msg = "button clicked")
}