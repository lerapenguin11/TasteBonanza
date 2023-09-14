package com.example.tastebonanza.business.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tastebonanza.business.model.Equipment

@Dao
interface EquipmentDao {

    @Query("SELECT * FROM equipment")
    fun getAllEquipment(): List<Equipment>

    @Insert
    fun insertEquipment(equipment: Equipment)
}