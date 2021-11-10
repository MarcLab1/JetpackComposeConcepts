package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcomposeconcepts.MyViewModel

var variable1 : String = "one"

@Composable
fun State2() {
    var viewModel : MyViewModel = MyViewModel()
    var navController = rememberNavController()


    NavHost(navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(navController, viewModel = viewModel)
        }
        composable(route = "first") {
            FirstScreen(navController, variable1, viewModel.mutableLiveData, viewModel.mutableStateVar)
        }
        composable(route = "second") {
            SecondScreen(navController, viewModel = viewModel)
        }
        composable(route = "third") {
            ThirdScreen(navController)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, viewModel: MyViewModel)
{
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {
        Button(onClick = { navController.navigate("first") }) {
            Text("first")
        }
        Button(onClick = { navController.navigate("second") }) {
            Text("second")
        }
    }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth())
    {
        Text(text = viewModel.mutableLiveData.value.toString())
        Text(text = viewModel.mutableStateVar.value.toString())
    }
}

@Composable
fun FirstScreen(navController: NavController, variable1: String, variable2: MutableLiveData<String>, variable3: MutableState<String>)
{
    Text(text = "first")
    //variable1 = "changed" -- regular parameters are val by default and cannot be reassigned
    variable2.value = "changed to 1st"
    variable3.value = "also changed to 1st"
}

@Composable
fun SecondScreen(navController: NavController, viewModel: MyViewModel)
{
    Text(text = "second")
    viewModel.mutableStateVar.value = "also changed to second"
    viewModel.mutableLiveData.value = "changed to second"
}

@Composable
fun ThirdScreen(navController: NavController) {


}
