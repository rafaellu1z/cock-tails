package com.devventure.cocktails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.devventure.cocktails.data.DrinkListRemoteEntity
import com.devventure.cocktails.data.network.CockTailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var drinkName: TextView
    lateinit var drinkContainer: ConstraintLayout
    lateinit var drinkImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drinkName = findViewById(R.id.drinkName)
        drinkContainer = findViewById(R.id.drinkContainer)
        drinkImage = findViewById(R.id.drinkImage)

        getDrink()

        drinkContainer.setOnClickListener{
            getDrink()
        }


    }

    private fun getDrink() {
        lifecycleScope.launch {
            try {
                val response = requestDrinks()
                val drink = response.drinks.random()
                drinkName.text = drink.strDrink
                Glide.with(this@MainActivity)
                    .load(drink.strDrinkThumb)
                    .into(drinkImage)
            } catch (e: Exception){
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
            }
        }
        // execute request
        // from the answer select a random drink
        // put the name of random drink selected in the textview
    }

    private suspend fun requestDrinks(): DrinkListRemoteEntity{
        return withContext(Dispatchers.IO){
            CockTailService.service.getDrinks()
        }
    }
}