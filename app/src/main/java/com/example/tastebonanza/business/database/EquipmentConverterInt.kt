package com.example.tastebonanza.business.database

import androidx.room.TypeConverter
import com.example.tastebonanza.business.model.Equipment

interface  EquipmentConverterInt {

    @TypeConverter
    fun fromArrayList(value: List<Equipment>?): String?

    @TypeConverter
    fun toArrayList(value: String?): List<Equipment>?
}