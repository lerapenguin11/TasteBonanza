package com.example.tastebonanza.business.database

import androidx.room.TypeConverter
import com.example.tastebonanza.business.model.Equipment
import org.json.JSONArray
import org.json.JSONObject

class EquipmentConverter {

    @TypeConverter
    fun fromArrayList(value: List<Equipment>?): String? {
        val result = value?.let { taskList ->
            JSONArray(taskList.map { task ->
                JSONObject().apply {
                    put("name", task.name)
                }
            }).toString()
        }

        return result
    }

    @TypeConverter
    fun toArrayList(value: String?): ArrayList<Equipment>? {
        val result = value?.let { jsonString ->
            val jsonArray = JSONArray(jsonString)
            val taskList = ArrayList<Equipment>()
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val name = jsonObject.getInt("name")
                taskList.add(Equipment(name = name))
            }
            taskList
        }

        return result
    }
}