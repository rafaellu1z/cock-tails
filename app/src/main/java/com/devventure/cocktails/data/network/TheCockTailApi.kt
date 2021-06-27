package com.devventure.cocktails.data.network

import com.devventure.cocktails.data.DrinkListRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCockTailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getDrinks(): DrinkListRemoteEntity

//    @GET("lookup.php")
//    suspend fun getDrinkDetail(@Query("i")id: Int): DrinkDetails
}