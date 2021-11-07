package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyButtonsAndRecomposition()
{
    var button1Click by remember {mutableStateOf(false)}
    var button2Click by remember {mutableStateOf(false)}

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Button(onClick = { button1Click = !button1Click }) {
            Text(text = "button1")
        }

        Button(onClick = { button2Click = !button2Click }) {
            Text(text = "button2")
        }
        Text(text = button1Click.toString())
        Text(text = button2Click.toString())

        if (button1Click)
            Text("you clicked the darn button 1")
        if (button2Click)
            Text("you clicked button 2")
    }
}


