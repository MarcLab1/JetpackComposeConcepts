package com.jetpackcomposeconcepts

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RecipeViewModel : ViewModel() {

    var number : MutableState<Int> = mutableStateOf(0)
    var recipe = mutableStateOf(Recipe())
    lateinit var recipeList : MutableState<ArrayList<Recipe>>

    init {

        var _recipeList = ArrayList<Recipe>()
        for(i in 1..10)
           _recipeList.add(Recipe(i, i.toString()))

        recipeList = mutableStateOf(_recipeList)
    }
}