package com.example.tastebonanza.business.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tastebonanza.business.model.Ingredients

@Dao
interface IngredientsDao {

    @Query("SELECT * FROM ingredients")
    fun getAllIngredients(): List<Ingredients>

    @Insert
    fun insertIngredients(ingredients: Ingredients)
}