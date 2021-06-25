package com.devventure.cocktails.data.network

import com.devventure.cocktails.data.DrinkListRemoteEntity
import retrofit2.http.GET

interface TheCockTailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getDrinks(): DrinkListRemoteEntity
}