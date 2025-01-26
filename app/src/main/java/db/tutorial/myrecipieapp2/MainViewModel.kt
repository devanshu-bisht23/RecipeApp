package db.tutorial.myrecipieapp2 //load data and store it in the ram cuz we fetched data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){ //help us get us the information from the data side to the ui side ////connects view with the model

    private val _mealState = mutableStateOf(RecipeState()) //what we see on the screen
    val mealState: State<RecipeState> = _mealState //to access the _mealState from the outside ////public variable for other classes to access

    init {
        fetchMeals() //we call this the moment our main view model is loaded
    }

    private fun fetchMeals() {
        viewModelScope.launch { //in this scope we can use out suspended code in the background
            try {
                val response = recipeService.getMealsss() //using this function to get meals //IMPORTANT POINT
                _mealState.value = _mealState.value.copy(
                    list = response.meals,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _mealState.value = _mealState.value.copy(
                    loading = false,
                    error = "error fetching meals ${e.message}"
                )
            } 
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Meal> = emptyList(), //changed Category to Meal
        val error: String? = null //nullable cuz we want our default data to bve null
    )
}