package com.example.tastebonanza.business.model


data class RecipeModel(
    val name: String,
    val equipment: List<EquipmentModel>,
    val iconList : String,
    val tag : Int,
    val icon : String,
    val servings : String,
    val time : Int,
    val calories : Int,
    val ingredients : List<IngredientsModel>,
    val recipe : Int
)
