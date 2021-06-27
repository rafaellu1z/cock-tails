package com.devventure.cocktails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devventure.cocktails.data.DrinkRemoteEntity

class DrinkAdapter (private val ctx: Context) :
    RecyclerView.Adapter<DrinkAdapter.DrinksViewHolder>() {
    var drinkList = listOf<DrinkRemoteEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.drink_item, parent, false)
        return DrinksViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        val drinkItem = drinkList[position]
        holder.bind(drinkItem)
    }

    override fun getItemCount(): Int = drinkList.size
    inner class DrinksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameContainer: TextView = itemView.findViewById(R.id.drinkName)
        private val imageContainer: ImageView = itemView.findViewById(R.id.drinkImage)

        fun bind(drinkItem: DrinkRemoteEntity) {
            nameContainer.text = drinkItem.strDrink
            Glide.with(ctx)
                .load(drinkItem.strDrinkThumb)
                .into(imageContainer)
        }
    }
}