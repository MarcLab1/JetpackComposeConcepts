package com.jetpackcomposeconcepts.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackcomposeconcepts.MyViewModel

@Composable
fun Composables(viewModel: MyViewModel) {
    //First1(viewModel)
    //Second2(viewModel)
    //Third3(viewModel)
    //storeValue("1", viewModel = viewModel)
    viewModel.string.value += "one "

    var buttonClick by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Row()
        {
            Button(onClick = { buttonClick = true })
            {
                Text("click me?")
            }
        }
        Row() {
            Text(viewModel.string.value.toString())
        }
    }




    if (buttonClick) {
        buttonClick(viewModel)
        buttonClick = false
    }
}

@Composable
fun buttonClick(viewModel: MyViewModel) {
    viewModel.string.value += "@"
}


@Composable
fun First1(viewModel: MyViewModel) {
    storeValue(msg = "1", viewModel)
}

@Composable
fun Second2(viewModel: MyViewModel) {
    storeValue(msg = "2", viewModel)
}

@Composable
fun Third3(viewModel: MyViewModel) {
    storeValue(msg = "3", viewModel)
}

@Composable
fun Fourth4(viewModel: MyViewModel) {
    storeValue(msg = "4", viewModel)
}

fun storeValue(msg: String, viewModel: MyViewModel) {
    viewModel.string.value += msg
}