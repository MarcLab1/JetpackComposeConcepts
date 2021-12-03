package com.jetpackcomposeconcepts.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@SuppressLint("UnrememberedMutableState")
@Composable
fun State3() {
    var ctx = LocalContext.current

    var number by remember { mutableStateOf(0) }
    var clicked1 by remember { mutableStateOf(false) }
    var clicked2 by remember { mutableStateOf(false) }
    var color = remember { mutableStateOf(Color.Red) }

    Column()
    {

        Button(onClick = { clicked1 = true })
        {
            Text(text = "+")
        }

        Button(onClick = { clicked2 = true })
        {
            Text(text = "-")
        }
        Box( contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(color = color.value, shape = RoundedCornerShape(4.dp))
                .clickable {

                    color.value = Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                })
        {
            Text(text = number.toString())
        }

    }

    if (clicked1) {
        number++
        clicked1 = false
    }
    if (clicked2) {
        number--
        clicked2 = false
    }
}

@Composable
fun toastMessage(num: Int) {

    if (num % 3 == 0) {
        var ctx = LocalContext.current
        Toast.makeText(ctx, num.toString(), Toast.LENGTH_SHORT).show()
    }
}