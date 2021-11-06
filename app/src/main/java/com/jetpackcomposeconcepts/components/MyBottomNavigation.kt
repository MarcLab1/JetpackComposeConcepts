package com.jetpackcomposeconcepts

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyBottomNavigation() {
    val navController = rememberNavController()

    Surface() {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController = navController)
            }, content = {
                NavHostStart(navController = navController)
            }
        )
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "First Page", style = TextStyle(fontSize = 20.sp))
        getBackStackTextBox()
        navController.backQueue.forEachIndexed { index, navBackStackEntry ->
            (
                    Text(
                        text = index.toString() + " " + navBackStackEntry.destination.toString(),
                        style = TextStyle(fontSize = 10.sp)
                    ))
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Second Page", style = TextStyle(fontSize = 20.sp))
        getBackStackTextBox()
        navController.backQueue.forEachIndexed { index, navBackStackEntry ->
            (
                    Text(
                        text = index.toString() + " " + navBackStackEntry.destination.toString(),
                        style = TextStyle(fontSize = 10.sp)
                    ))
        }
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Third Page", style = TextStyle(fontSize = 20.sp))
        getBackStackTextBox()
        var count: Int = 1 //demonstration of different way of indexing than foreachindexed
        for (navBackStackEntry in navController.backQueue) {
            Text(
                text = count.toString() + " " + navBackStackEntry.destination.toString(),
                style = TextStyle(fontSize = 10.sp)
            )
            count++
        }
    }
}


@Composable
fun FourthScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "4th Page", style = TextStyle(fontSize = 20.sp))
        getBackStackTextBox()
        var count: Int = 1 //demonstration of different way of indexing than foreachindexed
        for (navBackStackEntry in navController.backQueue) {
            Text(
                text = count.toString() + " " + navBackStackEntry.destination.toString(),
                style = TextStyle(fontSize = 10.sp)
            )
            count++
        }
    }
}

@Composable
fun getBackStackTextBox()
{
    return Text(text = "BackStack:", style = TextStyle(fontSize = 15.sp), modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    BottomNavigation() {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Constants.BottomNavItems.forEach { item ->

            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {

                        navController.navigate(item.route) {
                            popUpTo("first") //so the back button takes us back to first, then back to the upper navigaiton (with buttons)
                            launchSingleTop = true  //no duplocates on the back stack
                        }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.label)
                },
                label = {
                    Text(text = item.label)
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
fun NavHostStart(
    navController: NavHostController
) {
    NavHost(navController, startDestination = "first",
    modifier = Modifier.padding(10.dp)) {
        composable(route = "first") {
            FirstScreen(navController)
        }
        composable(route = "second") {
            SecondScreen(navController = navController)
        }
        composable(route = "third") {
            ThirdScreen(navController = navController)
        }
        composable(route = "fourth") {
            FourthScreen(navController = navController)
        }
    }
}

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "first",
            icon = Icons.Filled.Home,
            route = "first"
        ),
        BottomNavItem(
            label = "second",
            icon = Icons.Filled.Search,
            route = "second"
        ),
        BottomNavItem(
            label = "third",
            icon = Icons.Filled.Person,
            route = "third"
        ),
        BottomNavItem(
            label = "fourth",
            icon = Icons.Filled.Phone,
            route = "fourth"
        )
    )
}

class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
)



