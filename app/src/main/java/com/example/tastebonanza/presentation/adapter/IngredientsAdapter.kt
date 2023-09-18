package com.example.tastebonanza.presentation.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastebonanza.R
import com.example.tastebonanza.business.model.Ingredients

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {

    private val ingredientsList = mutableListOf<Ingredients>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ingredients, parent, false)

        return IngredientsViewHolder(view)
    }

    override fun getItemCount(): Int = ingredientsList.size

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val ingredients : Ingredients = ingredientsList[position]

        holder.name.setText(ingredients.ingredientName)
        holder.count.text = ingredients.ingredientCount.toString()
        holder.ed.setText(ingredients.ingredientEd)
    }

    fun setItem(ingredientsNew: List<Ingredients>) {
        ingredientsList.clear()
        ingredientsList.addAll(ingredientsNew)
        notifyDataSetChanged()
    }

    class IngredientsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name : TextView = view.findViewById(R.id.tv_name_ingredients)
        val count : TextView = view.findViewById(R.id.tv_count_ingredients)
        val ed : TextView = view.findViewById(R.id.tv_ingredients_ed)
    }
}