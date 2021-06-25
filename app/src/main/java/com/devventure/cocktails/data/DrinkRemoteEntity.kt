package com.devventure.cocktails.data

import com.google.gson.annotations.SerializedName

data class DrinkRemoteEntity (
    @SerializedName("idDrink")
    val id: String,
    val strDrink: String,
    val strDrinkThumb: String
)