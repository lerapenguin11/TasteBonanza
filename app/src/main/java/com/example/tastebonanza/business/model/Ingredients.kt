package com.example.tastebonanza.business.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class Ingredients(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val ingredientName : Int,
    val ingredientCount : Int,
    val ingredientEd : Int
)
