package db.tutorial.myrecipieapp2 //details for each category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MealDetailScreen(meal: Meal) { // Changed from Category to Meal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = meal.strMeal, textAlign = TextAlign.Center) // Changed from strCategory to strMeal
        Image(
            painter = rememberAsyncImagePainter(meal.strMealThumb), // Changed from strCategoryThumb to strMealThumb
            contentDescription = "${meal.strMeal} Thumbnail", // Changed from strCategory to strMeal
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )

        Text(
            text = meal.strInstructions, // Changed from strCategoryDescription to strInstructions
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }
}
