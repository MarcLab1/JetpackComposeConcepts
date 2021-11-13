package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcomposeconcepts.R

@Preview //Preview only works with no params or default params
@Composable
fun Mitch1(str: String = "alo?") {

    LazyColumn(modifier = Modifier
        .padding(10.dp)
        .background(Color(0xFFE5E5E5))
        .fillMaxSize()) {
        item {
            Image(
                painterResource(id = R.drawable.student1), contentDescription = "pic",
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clip(CircleShape)
            )
            Text(
                text = str,
                style = TextStyle(Color.Red, fontSize = 33.sp, fontFamily = FontFamily.Cursive)
            )
            Text(
                text = str,
                style = TextStyle(
                    Color(0xFF338811),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(str)
        }
    }
}