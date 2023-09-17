package com.example.tastebonanza.business.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tastebonanza.business.database.EquipmentConverter
import com.example.tastebonanza.business.database.IngredientsConverter

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: Int,
    @TypeConverters(EquipmentConverter::class)
    val equipment: List<Equipment>,
    val iconList: Int,
    val tag: Int,
    val icon: String,
    val servings: String,
    val time: String,
    val calories: Int,
    @TypeConverters(IngredientsConverter::class)
    val ingredients: List<Ingredients>,
    val recipe: Int
)