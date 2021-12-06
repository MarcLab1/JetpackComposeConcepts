package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.jetpackcomposeconcepts.MySingleton
import com.jetpackcomposeconcepts.MyViewModel

@Composable
fun SingletonInKotlin(viewModel: MyViewModel)
{
    var user = MySingleton.singletonUser  //replaces the old getInstance() we used to use in java
    Column() {
        Text(text = user.hashCode().toString())
        Text(text = MySingleton.getUserEmail())

    }

}