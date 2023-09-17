package com.example.tastebonanza.business.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tastebonanza.business.model.EquipmentModel
import com.example.tastebonanza.business.model.IngredientsModel
import com.example.tastebonanza.business.model.RecipeModel

class EquipmentRepository {
    fun getEquipmentListReading(equipment: MutableList<EquipmentModel>): LiveData<MutableList<EquipmentModel>> {
        val mutableData = MutableLiveData<MutableList<EquipmentModel>>()
        val list = mutableListOf<EquipmentModel>()

        for (i in equipment){
            val name = i.name

            val listEquipmentModel = EquipmentModel(
                name = name
            )
            list.add(listEquipmentModel)
        }

        mutableData.value = list

        return mutableData
    }

    fun getRecipeAllListReading(recipe: MutableList<RecipeModel>): LiveData<MutableList<RecipeModel>> {
        val mutableData = MutableLiveData<MutableList<RecipeModel>>()
        val list = mutableListOf<RecipeModel>()

        for (i in recipe){
            val name = i.name
            val equipment = i.equipment
            val iconList = i.iconList
            val tag = i.tag
            val icon = i.icon
            val servings = i.servings
            val time = i.time
            val calories = i.calories
            val ingredients = i.ingredients
            val recipe = i.recipe

            val listEquipmentModel = RecipeModel(
                name = name, equipment = equipment, iconList = iconList,
                tag = tag, icon = icon, servings = servings, time = time,
                calories = calories, ingredients = ingredients, recipe = recipe
            )
            list.add(listEquipmentModel)
        }

        mutableData.value = list

        return mutableData
    }
}