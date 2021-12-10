package com.jetpackcomposeconcepts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {

    var clicked = mutableStateOf(false)
}