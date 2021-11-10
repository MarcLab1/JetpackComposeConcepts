package com.jetpackcomposeconcepts

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MyViewModel : ViewModel() {

    var students : MutableLiveData<ArrayList<Student>>
    var num1 : MutableLiveData<Int>
    var num2 : MutableLiveData<Int>
    var clicked : MutableLiveData<Boolean>
    var myDarkTheme: MutableState<Boolean>
    var showToast : MutableState<Boolean>
    var mutableStateVar : MutableState<String>
    lateinit var mutableLiveData : MutableLiveData<String>

    init
    {
        students = MutableLiveData()
        students.value = StudentRepo().students
        num1 = MutableLiveData(1)
        num2 = MutableLiveData(1)
        clicked = MutableLiveData(false)
        myDarkTheme = mutableStateOf(false)
        showToast = mutableStateOf(false)
        mutableStateVar = mutableStateOf("original")
        mutableLiveData = MutableLiveData("original")
    }

    val flowTimer : Flow<String> = flow {
        for (i in 1..5){
            emit(""+i)
            delay(1000)
        }
        emit("done")
    }
}