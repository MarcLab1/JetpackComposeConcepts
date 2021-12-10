package com.jetpackcomposeconcepts.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jetpackcomposeconcepts.TestViewModel
import kotlin.random.Random

@Composable
fun TestPage() {
    var vm = TestViewModel()

    Column(modifier = Modifier.fillMaxSize()) {
        Num1Col()
        Num2Col()
        Num3Col()
        MyButton1(vm)
        MyText(vm)
        MyList(vm)
    }
}


@Composable
fun MyList(vm: TestViewModel) {
    var myList = mutableListOf<String>()
    myList.add("yes")
    myList.add("no")
    myList.add("f no")

    for (s in myList) {
        MyItem(s)
    }
}

@Composable
fun MyItem(s: String) {
    var cl = remember {
        mutableStateOf(false)
    }
    Text(text = s + " " + cl.value,
        Modifier
            .clickable { cl.value = !cl.value }
            .background(
                color = Color(
                    Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                )
            ))
}

@Composable
fun MyText(vm: TestViewModel) {
    Text(text = vm.clicked.value.toString())
}

@Composable
fun MyButton1(vm: TestViewModel) {
    var button1Clicked = remember {
        mutableStateOf(false)
    }

    var value = remember {
        mutableStateOf(0)
    }

    Button(onClick = {
        button1Clicked.value = true
        vm.clicked.value = true
    }) {
        Text(text = value.value.toString())
    }

    if (button1Clicked.value == true) {
        value.value += 10
        button1Clicked.value = false
    }
}

@Composable
fun Num1Col() {
    var num1 = 10 //nada
    Column(modifier = Modifier
        .clickable {
            num1 -= 10
        }
        .fillMaxWidth()
        .background(
            color = Color(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
        )) {
        Text(text = num1.toString())
    }
}

@Composable
fun Num2Col() {
    var num2 = remember {
        mutableStateOf(1)
    }
    Column(modifier = Modifier
        .clickable { num2.value -= 10 }
        .fillMaxWidth()
        .background(
            color = Color(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
        )) {
        Text(text = num2.value.toString())
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Num3Col() {
    var num3 = mutableStateOf(10)
    Column(modifier = Modifier
        .clickable { num3.value -= 10 }
        .fillMaxWidth()
        .background(
            color = Color(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
        )) {
        Text(text = num3.value.toString())
    }
}