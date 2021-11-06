package com.jetpackcomposeconcepts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MyViewModel : ViewModel() {

    var students : MutableLiveData<ArrayList<Student>>
    init
    {
        students = MutableLiveData()
        students.value = StudentRepo().students
    }

    val flowTimer : Flow<String> = flow {
        for (i in 1..5){
            emit(""+i)
            delay(1000)
        }
        emit("done")
    }
}