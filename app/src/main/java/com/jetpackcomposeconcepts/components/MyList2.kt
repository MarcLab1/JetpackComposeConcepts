package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcomposeconcepts.Box
import com.jetpackcomposeconcepts.MyViewModel
import com.jetpackcomposeconcepts.R


@Composable
fun MyList2(viewModel: MyViewModel) {
    var nav = rememberNavController()
    NavHost(nav, startDestination = "test") {
        composable(route = "test") {
            Test(nav, viewModel = viewModel)
        }
        composable("page/{boxId}")
        { backStackEntry ->
            Page(
                backStackEntry.arguments?.getString("boxId")!!,
                viewModel.boxes.value?.get(backStackEntry.arguments?.getString("boxId")!!.toInt()),
                viewModel
            )
        }
    }
}

@Composable
fun Test(nav: NavController, viewModel: MyViewModel) {

    LazyColumn(modifier = Modifier.padding(16.dp)) {

        items(viewModel.boxes.value?.size!!)
        {
            putBox(viewModel.boxes.value!![it], nav)
        }
    }
}

@Composable
fun putBox(box: Box, nav: NavController) {
    var ctx = LocalContext.current

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            val boxId = box.boxId
            nav.navigate("page/" + boxId)
        }) {

        Text(text = box.toString())

        Image(
            painter = painterResource(id = R.drawable.student1 ),
            contentDescription = "nothing",
            modifier = Modifier.size(40.dp)
        )
    }

}


@Composable
fun Page(boxId: String, box: Box?, viewModel: MyViewModel) {

    Column() {
        Text(text = boxId)
        Text(text = box.toString())
        Text(text = viewModel.boxes.value?.get(boxId.toInt()).toString())
    }

}