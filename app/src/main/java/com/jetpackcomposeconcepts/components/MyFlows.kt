package com.jetpackcomposeconcepts

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MyFlows()
{
    //flow Producer
    val flow = flow {

        for (i in 1..5)
        {
            emit(i)
            delay (1000L)
        }
    }


    /*
    //flow consumer
    var ctx = LocalContext.current
    val composableScope = rememberCoroutineScope()
    composableScope.launch {
        flow.buffer().collect {
           delay (2000L)
            showMessage(ctx, it.toString())
       }
    }
    */

    //flow consumer viewModel
    var ctx = LocalContext.current
    var viewModel = MyViewModel()
    val composableScope2 = rememberCoroutineScope()
    composableScope2.launch {
        viewModel.flowTimer.collect {
            showMessage(ctx, it)
        }
    }

}

fun showMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
