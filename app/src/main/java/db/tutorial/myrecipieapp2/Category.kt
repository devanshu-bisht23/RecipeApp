package db.tutorial.myrecipieapp2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String
) : Parcelable

data class MealsResponse(val meals: List<Meal>) //list of each individual meal is stored in this list