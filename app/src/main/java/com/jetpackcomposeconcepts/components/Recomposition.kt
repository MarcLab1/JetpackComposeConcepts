package com.jetpackcomposeconcepts.components

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jetpackcomposeconcepts.MyViewModel


lateinit var viewModel: MyViewModel

@Composable
fun Recomposition() {

    viewModel = MyViewModel()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        MyButton1()
        MyText1()
        MyText2()
        MyTimer()
    }
}

@Composable
fun MyButton1() {

    Row(
        modifier = Modifier.background(Color.White).fillMaxWidth()
    ) {
        var clicked by remember { mutableStateOf(viewModel.clicked.value!!) }
        if (clicked) {
            first()
            second()
            third()
        }

        Button(onClick = {
            clicked = !clicked
            viewModel.num1.value = viewModel.num1.value!! + 1
        })
        {
            Text(clicked.toString())
        }
    }
    Row( modifier = Modifier.background(Color.White).fillMaxWidth())
    {
        Text(viewModel.num1.value.toString())
    }
}

@Composable
fun MyText1() {
    Row(modifier = Modifier.background(Color.LightGray).fillMaxWidth()) {
        var num1 = viewModel.num1.value!!
        Text(num1.toString())
    }
}


@Composable
fun MyText2() {

    Row(modifier = Modifier.background(Color.White).fillMaxWidth()) {
        var time = System.currentTimeMillis()
        Text(time.toString())
    }
}


@Composable
fun MyTimer() {
    Row(modifier = Modifier.background(Color.LightGray).fillMaxWidth()) {
        var time: Long by remember {
            mutableStateOf(0)
        }
        object : CountDownTimer(100, 100) {
            override fun onTick(millis: Long) {
                time++
            }

            override fun onFinish() {
            }
        }.start()
        Column() {
            Text(text = time.toString())
            var time = System.currentTimeMillis().toString()
            Text(time)
        }
    }
}

@Composable
fun first() {
    Log.d("1", "1st")
}

@Composable
fun second() {
    Log.d("2", "2nd")
}

@Composable
fun third() {
    Log.d("3", "3rd")
}