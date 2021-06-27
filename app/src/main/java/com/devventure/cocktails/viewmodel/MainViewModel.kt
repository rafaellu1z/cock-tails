package com.devventure.cocktails.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devventure.cocktails.data.DrinkListRemoteEntity
import com.devventure.cocktails.data.network.CockTailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainViewModel: ViewModel() {
    val listDrinks = MutableLiveData<DrinkListRemoteEntity>()

    fun getDrinks() {
        viewModelScope.launch {
            try {
                listDrinks.value = getDrinksList()
            } catch (e: Exception) {
                Log.e("MainViewModel", e.toString())
            }
        }
    }

    private suspend fun getDrinksList(): DrinkListRemoteEntity {
        return withContext(Dispatchers.IO) {
            CockTailService.service.getDrinks()
        }
    }
}