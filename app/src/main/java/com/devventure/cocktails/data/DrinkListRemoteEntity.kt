package com.devventure.cocktails.data

import com.google.gson.annotations.SerializedName

data class DrinkListRemoteEntity(
    @SerializedName("drinks")
    val drinks: List<DrinkRemoteEntity>
)