package com.devventure.cocktails.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

private val retrofit = Retrofit.Builder()
                                        .baseUrl(BASE_URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()

object CockTailService{
    val service: TheCockTailApi by lazy {
        retrofit.create(TheCockTailApi::class.java)
    }
}
