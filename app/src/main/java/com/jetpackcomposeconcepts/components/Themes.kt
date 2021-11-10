package com.jetpackcomposeconcepts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Themes() {

    var myDarkTheme by remember {
        mutableStateOf(false)
    }


    var str = "Hello World!"
    MyComposeNativeTheme(darkTheme = myDarkTheme) {
        Surface() {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                content = {

                    Button(onClick =
                    {
                        when (myDarkTheme) {
                            true -> {
                                myDarkTheme = false
                                //viewModel.myDarkTheme.value = false
                            }
                            false -> {
                                myDarkTheme = true
                                //viewModel.myDarkTheme.value = true
                            }
                            else -> {
                                myDarkTheme = true
                                //viewModel.myDarkTheme.value = true
                            }
                        }
                    }
                    )
                    {
                        Text(text = "darkMode = $myDarkTheme")
                    }
                    Text(text = "$str")
                }
            )
        }
    }
}

