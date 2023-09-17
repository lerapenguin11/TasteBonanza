package com.example.tastebonanza.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tastebonanza.R
import com.example.tastebonanza.business.model.Recipe

class RecipeAdapter(private val context: Context) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>(){
    private val recipeList = mutableListOf<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)

        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
       val recipe : Recipe = recipeList[position]

        holder.name.setText(recipe.name)
        //Glide.with(holder.itemView).load(recipe.icon).into(holder.icon)
        holder.icon.setImageDrawable(ContextCompat.getDrawable(context, recipe.iconList))
    }

    fun setItem(recipeNew: List<Recipe>) {
        recipeList.clear()
        recipeList.addAll(recipeNew)
        notifyDataSetChanged()
    }


    class RecipeViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name : TextView = view.findViewById(R.id.tv_name_recipe)
        val icon : ImageView = view.findViewById(R.id.icon_item_recipe)
    }
}