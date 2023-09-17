package com.example.tastebonanza.business.model


data class RecipeModel(
    val name: Int,
    val equipment: List<EquipmentModel>,
    val iconList : Int,
    val tag : Int,
    val icon : String,
    val servings : String,
    val time : String,
    val calories : Int,
    val ingredients : List<IngredientsModel>,
    val recipe : Int
)
