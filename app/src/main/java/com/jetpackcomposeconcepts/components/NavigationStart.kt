package com.jetpackcomposeconcepts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcomposeconcepts.components.*

@Composable
fun NavigationStart() {


    MyComposeNativeTheme(darkTheme = false) {

        val navController = rememberNavController()
        var viewModel = MyViewModel()

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
            composable(route = "mybuttonsandrecomposition") {
                MyButtonsAndRecomposition()
            }
            composable(route = "spinner") {
                Spinner()
            }
            composable(route = "state1") {
                State1(viewModel = MyViewModel())
            }
            composable(route = "state2") {
                State2()
            }
            composable(route = "mitch1") {
                Mitch1()
            }
            composable(route = "state3") {
                State3()
            }
            composable(route = "animate") {
                Animate()
            }
            composable(route = "permissions") {
                Permissions()
            }
            composable(route = "list2") {
                List2(viewModel)
            }
            composable(route = "composables") {
                Composables(viewModel)
            }
        }

    }
}

@Composable
fun NavigationFirstScreen(navController: NavController) {

    var myButtons = MyButtons()
    LazyColumn(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        /*
        itemsIndexed(myButtons.buttons)
        {index, item ->
            putButton(myButton = item, navController = navController)
        }
        */
        items(myButtons.buttons)
        { it ->
            putButton(myButton = it, navController = navController)
        }
    }
}

@Composable
fun putButton(myButton: MyButton, navController: NavController) {
    Button(modifier = Modifier.padding(top = 3.dp, bottom = 3.dp),
        onClick = { navController.navigate(myButton.route) }) {
        Text(myButton.text)
    }
}

class MyButtons {
    val buttons = listOf(
        MyButton(
            route = "counters",
            text = "Button Counters"
        ),
        MyButton(route = "textbox", text = "Hello Name Text Box"),
        MyButton(route = "themes", text = "themes"),
        MyButton(route = "scaffold", text = "scaffold"),
        MyButton(route = "list", text = "Lazy List"),
        MyButton(route = "bottomnavigation", text = "Bottom Navigation"),
        MyButton(route = "flows", text = "Flows"),
        MyButton(route = "recomposition", text = "Recomposition"),
        MyButton(route = "mybuttonsandrecomposition", text = "Buttons & Recomposition"),
        MyButton(route = "spinner", text = "Spinner"),
        MyButton(route = "state1", text = "State & ViewModel 1"),
        MyButton(route = "state2", text = "State & ViewModel 2"),
        MyButton(route = "mitch1", text = "Mitch All Together?"),
        MyButton(route = "state3", text = "More State"),
        MyButton(route = "animate", text = "Animate"),
        MyButton(
            route = "permissions", text = "Permissions"
        ),
        MyButton(
            route = "list2", text = "List2"
        ),
        MyButton(
            route = "composables", text = "Composables"
        )
    )
}

class MyButton(
    val route: String,
    val text: String,
    val viewModel: MyViewModel? = null
)
