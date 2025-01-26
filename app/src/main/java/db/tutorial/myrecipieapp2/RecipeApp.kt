package db.tutorial.myrecipieapp2 //taking care of navigation and basically 2nd layer after the entry point

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel() //instance of the class MainViewModel
    val viewstate by recipeViewModel.mealState // Changed categoriesState to mealsState

    NavHost(navController = navController , startDestination = Screen.RecipeScreen.route){
        composable(route= Screen.RecipeScreen.route){
            RecipeScreen(viewstate = viewstate, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("meal", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route= Screen.DetailScreen.route){
            val meal = navController.previousBackStackEntry?.savedStateHandle?.
            get<Meal>("meal") ?: Meal("", "", "", "")
            MealDetailScreen(meal = meal) // Changed CategoryDetailScreen to MealDetailScreen
        }
    }
}