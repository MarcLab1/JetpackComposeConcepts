package com.jetpackcomposeconcepts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Tabs(navController: NavController) {

    var tabIndex by remember { mutableStateOf(0) }
    //var ctx = LocalContext.current
    val tabData = listOf(
        "First",
        "Second",
        "Third",
        "Fourth",
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(selectedTabIndex = tabIndex) {
            tabData.forEachIndexed { index, text ->
                Tab(selected = tabIndex == index, onClick = {
                    tabIndex = index
                }, text = {
                    Text(text = text)
                })
            }
        }

        var mytext by remember {
            mutableStateOf("")
        }

        when (tabIndex) {

            0 -> mytext = tabData[0]
            1 -> mytext = tabData[1]
            2 -> mytext = tabData[2]
            3 -> mytext = tabData[3]
            else -> mytext = tabData[0]
        }

        Text(text = mytext, modifier = Modifier.padding(25.dp))
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.padding(25.dp)
        ) {
            Text("Go back home")
        }
    }
}
