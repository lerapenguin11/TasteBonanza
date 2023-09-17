package com.example.tastebonanza.business.database

import androidx.room.TypeConverter
import com.example.tastebonanza.business.model.Ingredients
import org.json.JSONArray
import org.json.JSONObject

class IngredientsConverter {

    @TypeConverter
    fun fromArrayList(value: List<Ingredients>?): String? {
        val result = value?.let { taskList ->
            JSONArray(taskList.map { task ->
                JSONObject().apply {
                    put("ingredientName", task.ingredientName)
                    put("ingredientCount", task.ingredientCount)
                    put("ingredientEd", task.ingredientEd)
                }
            }).toString()
        }

        return result
    }

    @TypeConverter
    fun toArrayList(value: String?): ArrayList<Ingredients>? {
        val result = value?.let { jsonString ->
            val jsonArray = JSONArray(jsonString)
            val taskList = ArrayList<Ingredients>()
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val name = jsonObject.getInt("ingredientName")
                val count = jsonObject.getInt("ingredientCount")
                val ed = jsonObject.getInt("ingredientEd")
                taskList.add(Ingredients(ingredientName = name, ingredientCount = count, ingredientEd = ed))
            }
            taskList
        }

        return result
    }
}