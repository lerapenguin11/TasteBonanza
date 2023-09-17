package com.example.tastebonanza.business.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tastebonanza.business.model.Recipe

@Dao
interface RecipeDao {
    /*@Query("SELECT * FROM recipes WHERE :equipment IN equipment")
    fun getRecipesByEquipment(equipment: String): List<Recipe>*/

    @Query("SELECT * FROM recipes WHERE equipment LIKE '%' || :equipment || '%'")
    fun getRecipesByEquipment(equipment: Int): MutableList<Recipe>

    @Insert
    fun insertRecipe(recipe: Recipe)
}