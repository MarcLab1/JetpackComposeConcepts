package com.jetpackcomposeconcepts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MyViewModel : ViewModel() {

    var students : MutableLiveData<ArrayList<Student>>
    lateinit var num1 : MutableLiveData<Int>
    lateinit var num2 : MutableLiveData<Int>
    lateinit var clicked : MutableLiveData<Boolean>

    init
    {
        students = MutableLiveData()
        students.value = StudentRepo().students
        num1 = MutableLiveData(1)
        num2 = MutableLiveData(1)
        clicked = MutableLiveData(false)
    }

    val flowTimer : Flow<String> = flow {
        for (i in 1..5){
            emit(""+i)
            delay(1000)
        }
        emit("done")
    }
}