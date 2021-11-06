package com.jetpackcomposeconcepts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcomposeconcepts.components.Recomposition

@Composable
fun NavigationStart() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable(route = "home") {
            NavigationFirstScreen(navController)
        }
        composable(route = "tabs") {
            Tabs(navController = navController) //we are passing the navcontroller as a param
        }
        composable(route = "counters") {
            ButtonCounters()
        }
        composable(route = "textbox") {
            HelloNameTextBox()
        }
        composable(route = "themes") {
            Themes()
        }
        composable(route = "scaffold") {
            MyScaffold()
        }
        composable(route = "list") {
            MyList()
        }
        composable(route = "bottomnavigation") {
            MyBottomNavigation()
        }
        composable(route = "flows") {
            MyFlows()
        }
        composable(route = "recomposition") {
            Recomposition()
        }
    }
}

@Composable
fun NavigationFirstScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        Button(onClick = { navController.navigate("tabs") }) {
            Text("Tab Layout")
        }
        Button(onClick = { navController.navigate("counters") }) {
            Text("Button Counters")
        }
        Button(onClick = { navController.navigate("textBox") }) {
            Text("Hello Name Text Box")
        }
        Button(onClick = { navController.navigate("themes") }) {
            Text("Themes")
        }
        Button(onClick = { navController.navigate("scaffold") }) {
            Text("Scaffold")
        }
        Button(onClick = { navController.navigate("list") }) {
            Text("(Lazy) List")
        }
        Button(onClick = { navController.navigate("bottomnavigation") }) {
            Text("Bottom Navigation")
        }
        Button(onClick = { navController.navigate("flows") }) {
            Text("Flows")
        }
        Button(onClick = { navController.navigate("recomposition") }) {
            Text("Recomposition")
        }
    }
}