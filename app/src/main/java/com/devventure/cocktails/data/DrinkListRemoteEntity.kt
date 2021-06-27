package com.devventure.cocktails.data

import com.google.gson.annotations.SerializedName

data class DrinkListRemoteEntity(
    val drinks: List<DrinkRemoteEntity>
)