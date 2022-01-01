package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun StateHoisting() {
    var clicked by remember { mutableStateOf(false) }
    var checked by remember { mutableStateOf(false) }
    var number by remember { mutableStateOf(0) }
    var string by remember { mutableStateOf("") }

    Column() {
        MyButton("click me", onClick = {
            clicked = !clicked
        })
        Text(text = clicked.toString())
        Text(text = number.toString())
        Text(text = string)

        MyFancyTextField(
            value = string, onValueChanged = {
                string = it
                number = string.length
            },
            modifier = Modifier.padding(30.dp)
        )
        Text(string)

        MyAwesomeCheckBox(checked = checked, onCheckChanged = {
            checked = !checked
        })
    }
}

@Composable
fun MyButton(value: String, onClick: () -> Unit) {
    Button(onClick = onClick) {

        Text(text = value)
    }
}

@Composable
fun MyFancyTextField(value: String, onValueChanged: (String) -> Unit, modifier: Modifier) {
    TextField(value = value, onValueChange = onValueChanged, modifier = modifier)
}

@Composable
fun MyAwesomeCheckBox(
    checked: Boolean,
    onCheckChanged: (Boolean) -> Unit
) {
    Column() {
        Checkbox(checked = checked, onCheckedChange = onCheckChanged)
        Text(checked.toString())
    }


}