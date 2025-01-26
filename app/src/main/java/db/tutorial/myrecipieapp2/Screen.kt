package db.tutorial.myrecipieapp2 //setting routes using sealed class

sealed class Screen (val route:String){
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}