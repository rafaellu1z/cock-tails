package com.devventure.cocktails

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.devventure.cocktails.R
import com.devventure.cocktails.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getDrinks()

        val recycler: RecyclerView = findViewById(R.id.items_recycler_view)
        val adapter = DrinkAdapter(this)

        recycler.adapter = adapter

        viewModel.listDrinks.observe(this, {
            adapter.drinkList = it.drinks
        })
    }
}