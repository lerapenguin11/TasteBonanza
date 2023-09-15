package com.example.tastebonanza.business.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val equipment: List<Equipment>,
    val iconList : String,
    val tag : Int,
    val icon : String,
    val servings : String,
    val time : Int,
    val calories : Int,
    val ingredients : List<Ingredients>,
    val recipe : Int
)