package com.jetpackcomposeconcepts

import androidx.compose.material.*
import androidx.compose.runtime.*

@Composable
fun MyScaffold() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    var timeText by remember {
        mutableStateOf(System.currentTimeMillis().toString())
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text("Top App Bar") }) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                timeText = System.currentTimeMillis().toString()
            }) {
                Text("+")
            }
        },
        drawerContent = { Text(text = "Drawer Content") },
        content = { Text(timeText) },
        bottomBar = { BottomAppBar() { Text("Bottom App Bar") } }
    )
}