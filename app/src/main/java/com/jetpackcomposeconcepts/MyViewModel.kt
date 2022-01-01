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
    lateinit var items : MutableLiveData<List<Item>>
    lateinit var string : MutableLiveData<String>
    lateinit var boxes : MutableLiveData<ArrayList<Box>>

    lateinit var excellentBox : MutableState<Box?>
    lateinit var excellentFancyItem : MutableState<Item?>

    lateinit var fancyItems : MutableState<List<Item>>

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

        var repo = ItemRepo()
        items = MutableLiveData(repo.items)

        string = MutableLiveData("")

        boxes = MutableLiveData<ArrayList<Box>>()

        var tempBoxes = ArrayList<Box>()
        tempBoxes.add(Box(0, "yero"))
        tempBoxes.add(Box(1, "one"))
        tempBoxes.add(Box(2, "two"))
        boxes.value = tempBoxes

        excellentBox = mutableStateOf(null)
        excellentFancyItem = mutableStateOf(null)

        var _fancyitems = ArrayList<Item>()
        _fancyitems.add(Item(0, false))
        _fancyitems.add(Item(1, false))
        _fancyitems.add(Item(2, false))
        fancyItems = mutableStateOf(_fancyitems)
    }

    val flowTimer : Flow<String> = flow {
        for (i in 1..5){
            emit(""+i)
            delay(1000)
        }
        emit("done")
    }
}