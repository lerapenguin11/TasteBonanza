package com.example.tastebonanza.business.database

import androidx.room.TypeConverter
import com.example.tastebonanza.business.model.Ingredients

interface IngredientsConverterInt {

    @TypeConverter
    fun fromArrayList(value: List<Ingredients>?): String?

    @TypeConverter
    fun toArrayList(value: String?): List<Ingredients>?
}