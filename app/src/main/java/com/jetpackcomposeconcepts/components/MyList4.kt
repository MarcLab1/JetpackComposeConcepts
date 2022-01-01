package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.jetpackcomposeconcepts.Item
import com.jetpackcomposeconcepts.MyViewModel
import com.jetpackcomposeconcepts.R


@Composable
fun MyList4(viewModel: MyViewModel) {
    var nav = rememberNavController()
    NavHost(nav, startDestination = "test") {
        composable(route = "test") {
            ItemList(nav, viewModel = viewModel)
        }
        composable("fancyitem/{itemNumber}")
        { backStackEntry ->
            ItemDetail(
                backStackEntry.arguments?.getString("itemNumber")!!,
                viewModel.fancyItems.value?.get(backStackEntry.arguments?.getString("itemNumber")!!.toInt()),
                viewModel
            )
        }
    }
}

@Composable
fun ItemList(nav: NavController, viewModel: MyViewModel) {

    LazyColumn(modifier = Modifier.padding(16.dp)) {

        items(viewModel.fancyItems.value)
        {   item->
            ItemCard(item, viewModel, nav)
        }
    }
}

@Composable
fun ItemCard(item: Item, viewModel: MyViewModel, nav: NavController) {
    var ctx = LocalContext.current
    val itemNumber = item.number
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            viewModel.excellentFancyItem.value = item
            nav.navigate("fancyitem/" + itemNumber)
        }) {

        Text(text = itemNumber.toString())

        Image(
            painter = painterResource(id = R.drawable.student1 ),
            contentDescription = "nothing",
            modifier = Modifier.size(40.dp)
        )
    }
}


@Composable
fun ItemDetail(itemNumber: String, item: Item?, viewModel: MyViewModel) {

    Column() {
        Text(text = item.toString())
        Text(text = viewModel.fancyItems.value?.get(itemNumber.toInt()).toString())
        Text(viewModel.excellentFancyItem.value.toString())
    }

}