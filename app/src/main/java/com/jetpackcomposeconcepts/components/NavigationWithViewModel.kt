package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcomposeconcepts.Recipe
import com.jetpackcomposeconcepts.RecipeViewModel


//
//Usually view model is shared for the whole composables scope, and init shouldn't be called more than once.
//But if you're using compose navigation, it creates a new model store owner for each destination.

@Composable
fun NavigationWithViewModel(vm : RecipeViewModel) {

    var nav = rememberNavController()
    //var vm2 : RecipeViewModel = viewModel()

    NavHost(navController = nav, startDestination = "recipelist")
    {
        composable("recipelist")
        {
            RecipeList(vm, nav)
        }
        composable("recipedetail/{recpeNumber}")
        { it->

            // Extracting the argument
//            val recipeNumber = it.arguments?.getString("recipeNumber")
//            if (recipeNumber != null) {
//                vm.recipe.value = vm.recipeList.value.get(recipeNumber.toInt()-1)
//            }

            RecipeDetail(vm, nav)
        }
        composable("recipefake")
        {
            RecipeFake(vm, nav)
        }
    }
}

@Composable
fun RecipeList(vm: RecipeViewModel, nav: NavController) {

    LazyColumn()
    {
        item()
        {
            Text(vm.toString(), modifier = Modifier.clickable {
                vm.recipe.value = Recipe(1,"1")
                nav.navigate("recipefake")

            })
        }
        items(vm.recipeList.value)
        { it ->
            RecipeView(vm = vm, nav = nav, recipe = it)
        }
    }
}

@Composable
fun RecipeView(vm: RecipeViewModel, nav: NavController, recipe: Recipe) {
   //var vm2 : RecipeViewModel = viewModel()
    Text(text = recipe.toString(),
        modifier = Modifier.clickable {
            vm.recipe.value = recipe
            nav.navigate("recipedetail/" + recipe.number.toString())
        })
}

@Composable
fun RecipeDetail(vm: RecipeViewModel, nav: NavController) {

    var vmNew : RecipeViewModel = viewModel()
    Column()
    {

        Text(vm.recipe.value.toString())
        Text(vmNew.recipe.value.toString())

        MyExample()
        MyExample2()
    }
}

@Composable
fun RecipeFake(vm: RecipeViewModel, nav: NavController)
{
    var vmNew : RecipeViewModel = viewModel()
    Column()
    {
        Text(vm.recipe.value.toString())
        Text(vmNew.recipe.value.toString())
    }
}

@Composable
fun MyExample(
    // Returns the same instance as long as the activity is alive,
    // just as if you grabbed the instance from an Activity or Fragment
    vm: RecipeViewModel = viewModel()
) { Text(text = vm.toString())}

@Composable
fun MyExample2(
    viewModel: RecipeViewModel = viewModel() // Same instance as in MyExample
) { Text(text = viewModel.toString())}



