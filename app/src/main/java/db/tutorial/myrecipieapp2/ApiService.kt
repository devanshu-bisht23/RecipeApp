package db.tutorial.myrecipieapp2 //get dta from api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/") //retrofit object created
    .addConverterFactory(GsonConverterFactory.create()) // we can convert objects in kotlin that why gson fun used
    .build()

val recipeService = retrofit.create(ApiService::class.java) //recipeService allow us to use retrofit to create based on the url in combination with apiService

interface ApiService {
    @GET("search.php?f=c") //GET comes from retrofit that allows us to make the http request //search.php is the endpoint
    suspend fun getMealsss(): MealsResponse //Here we using suspend to make out programme async //meal response is just a list
}
