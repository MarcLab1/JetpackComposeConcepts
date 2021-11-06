package com.jetpackcomposeconcepts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ButtonCounters() {
    var num1 by remember { mutableStateOf(0) }
    //remember - allows you to remember state from previous recompose invocation
    //store value just in case recompose will be called
    //mutablestateof - store the value AND in case update value trigger recompose for all elements using this data.

    var num2: Int = 0

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        Button(onClick = {
            num1++
            num2++
        })
        {
            Text("num ++")
        }

        Text("remember mutableStateOf (Int) = " + num1.toString())
        Text("Int = " + num2.toString())
    }
}