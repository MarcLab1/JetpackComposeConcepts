package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import com.jetpackcomposeconcepts.Item
import com.jetpackcomposeconcepts.MyViewModel

@Composable
fun List2(viewModel: MyViewModel) {
    var items = viewModel.items.value
    LazyColumn(
    )
    {

        item()
        {
            for (item in viewModel.items.value!!) {
                showItem(item, viewModel = viewModel)
            }
        }

        items(viewModel.items.value?.size!!)
        {
            showSummary2(viewModel.items.value!![it])
        }
    }
}

@Composable
fun showItem(item: Item, viewModel: MyViewModel) {
    val checked = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    )
    {
        Text(text = item.toString())
        Checkbox(checked = checked.value, onCheckedChange = {
            checked.value = it
            item.selected = it

        })
        Text(item.selected.toString())
    }
}

@Composable
fun showSummary(items: List<Item>) {
    Column() {
        items.forEach()
        {
            if (it.selected)
                Text(text = it.name + " is true")
            else
                Text(text = it.name + " is false")
        }
    }
}

@Composable
fun showSummary2(item: Item) {
    Column() {
        if (item.selected)
            Text(text = item.name + " is true")
        else
            Text(text = item.name + " is false")
    }

}
