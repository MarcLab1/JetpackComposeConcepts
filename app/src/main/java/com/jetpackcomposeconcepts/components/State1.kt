package com.jetpackcomposeconcepts.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.jetpackcomposeconcepts.MyViewModel


@Composable
fun State1(viewModel: MyViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        MyTop(viewModel = viewModel, color = Color(red = 99, blue = 99, green = 77))
        MyBottom(viewModel)
    }
}

@Composable
fun MyTop(viewModel: MyViewModel, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = color).padding(10.dp).fillMaxWidth()) {
        Button(onClick = {

            when (viewModel.showToast.value) {
                true -> viewModel.showToast.value = false
                false -> viewModel.showToast.value = true
                else -> viewModel.showToast.value = false
            }
        }
        )
        {
            Text(text = "Show dialog? " + viewModel.showToast.value.toString())
        }

        Text(text = "Show dialog? " + viewModel.showToast.value.toString())
    }


    var ctx = LocalContext.current
    if (viewModel.showToast.value) {
        Toast.makeText(ctx, "true!", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun MyBottom(viewModel: MyViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top=25.dp)) {
        Text(text = "Show dialog? " + viewModel.showToast.value.toString())
    }
}





