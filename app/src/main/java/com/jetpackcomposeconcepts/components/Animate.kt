package com.jetpackcomposeconcepts.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun Animate() {
    var size by remember { mutableStateOf(200.dp) }
    val animateSize by animateDpAsState(
        targetValue = size,
        tween(
            durationMillis = 3
        )
    ) {

    }
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000)
        )
    )

    Box(modifier = Modifier
        .size(animateSize)
        .clickable {
            size += 20.dp

        }
        .background(color = color)
    )
    {
        Text(text = "hello")
    }
}