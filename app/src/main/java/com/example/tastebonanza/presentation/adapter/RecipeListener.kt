package com.example.tastebonanza.presentation.adapter

import com.example.tastebonanza.business.model.Recipe

interface RecipeListener {

    fun getRecipeDetails(recipe : Recipe)
}