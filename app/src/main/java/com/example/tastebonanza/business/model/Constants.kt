package com.example.tastebonanza.business.model

import com.example.tastebonanza.R

object Constants {

    fun getTrendingNews() : MutableList<EquipmentModel>{
        val equipmentList = mutableListOf<EquipmentModel>()

        val equipment1 = EquipmentModel(R.string.equipment1)
        equipmentList.add(equipment1)

        val equipment2 = EquipmentModel(R.string.equipment2)
        equipmentList.add(equipment2)

        val equipment3 = EquipmentModel(R.string.equipment3)
        equipmentList.add(equipment3)

        val equipment4 = EquipmentModel(R.string.equipment4)
        equipmentList.add(equipment4)

        val equipment5 = EquipmentModel(R.string.equipment5)
        equipmentList.add(equipment5)

        val equipment6 = EquipmentModel(R.string.equipment6)
        equipmentList.add(equipment6)

        val equipment7 = EquipmentModel(R.string.equipment7)
        equipmentList.add(equipment7)

        return equipmentList
    }

    fun getRecipe() : MutableList<RecipeModel>{
        val recipeList = mutableListOf<RecipeModel>()

        val recipe1 = RecipeModel(R.string.recipe_name1, listOf(EquipmentModel(R.string.equipment2)), R.drawable.img1, R.string.tag1,
                        "https://bye-bye-calories.ru/wp-content/uploads/d/e/5/de5c8c2e08a375404ab53a6faaa8a305.jpeg",
                                "4-5", "1,5h", 143, listOf(
                IngredientsModel(R.string.ing1, 500, R.string.ingEg1,),
                IngredientsModel(R.string.ing2, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing3, 200, R.string.ingEg1,),
                IngredientsModel(R.string.ing4, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing5, 3, R.string.ingEg9,),
                IngredientsModel(R.string.ing6, 200, R.string.ingEg1,)), R.string.recipe1
        )
        recipeList.add(recipe1)

        val recipe2 = RecipeModel(R.string.recipe_name1, listOf(EquipmentModel(R.string.equipment1)), R.drawable.img1, R.string.tag1,
            "https://bye-bye-calories.ru/wp-content/uploads/d/e/5/de5c8c2e08a375404ab53a6faaa8a305.jpeg",
            "4-5", "1,5h", 143, listOf(
                IngredientsModel(R.string.ing1, 500, R.string.ingEg1,),
                IngredientsModel(R.string.ing2, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing3, 200, R.string.ingEg1,),
                IngredientsModel(R.string.ing4, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing5, 3, R.string.ingEg9,),
                IngredientsModel(R.string.ing6, 200, R.string.ingEg1,)), R.string.recipe1
        )
        recipeList.add(recipe2)

        val recipe3 = RecipeModel(R.string.recipe_name1, listOf(EquipmentModel(R.string.equipment3)), R.drawable.img1, R.string.tag1,
            "https://bye-bye-calories.ru/wp-content/uploads/d/e/5/de5c8c2e08a375404ab53a6faaa8a305.jpeg",
            "4-5", "1,5h", 143, listOf(
                IngredientsModel(R.string.ing1, 500, R.string.ingEg1,),
                IngredientsModel(R.string.ing2, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing3, 200, R.string.ingEg1,),
                IngredientsModel(R.string.ing4, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing5, 3, R.string.ingEg9,),
                IngredientsModel(R.string.ing6, 200, R.string.ingEg1,)), R.string.recipe1
        )
        recipeList.add(recipe3)

        val recipe4 = RecipeModel(R.string.recipe_name1, listOf(EquipmentModel(R.string.equipment4)), R.drawable.img1, R.string.tag1,
            "https://bye-bye-calories.ru/wp-content/uploads/d/e/5/de5c8c2e08a375404ab53a6faaa8a305.jpeg",
            "4-5", "1,5h", 143, listOf(
                IngredientsModel(R.string.ing1, 500, R.string.ingEg1,),
                IngredientsModel(R.string.ing2, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing3, 200, R.string.ingEg1,),
                IngredientsModel(R.string.ing4, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing5, 3, R.string.ingEg9,),
                IngredientsModel(R.string.ing6, 200, R.string.ingEg1,)), R.string.recipe1
        )
        recipeList.add(recipe4)

        val recipe5 = RecipeModel(R.string.recipe_name1, listOf(EquipmentModel(R.string.equipment5)), R.drawable.img1, R.string.tag1,
            "https://bye-bye-calories.ru/wp-content/uploads/d/e/5/de5c8c2e08a375404ab53a6faaa8a305.jpeg",
            "4-5", "1,5h", 143, listOf(
                IngredientsModel(R.string.ing1, 500, R.string.ingEg1,),
                IngredientsModel(R.string.ing2, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing3, 200, R.string.ingEg1,),
                IngredientsModel(R.string.ing4, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing5, 3, R.string.ingEg9,),
                IngredientsModel(R.string.ing6, 200, R.string.ingEg1,)), R.string.recipe1
        )
        recipeList.add(recipe5)

        val recipe6 = RecipeModel(R.string.recipe_name1, listOf(EquipmentModel(R.string.equipment6)), R.drawable.img1, R.string.tag1,
            "https://bye-bye-calories.ru/wp-content/uploads/d/e/5/de5c8c2e08a375404ab53a6faaa8a305.jpeg",
            "4-5", "1,5h", 143, listOf(
                IngredientsModel(R.string.ing1, 500, R.string.ingEg1,),
                IngredientsModel(R.string.ing2, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing3, 200, R.string.ingEg1,),
                IngredientsModel(R.string.ing4, 1, R.string.ingEg2,),
                IngredientsModel(R.string.ing5, 3, R.string.ingEg9,),
                IngredientsModel(R.string.ing6, 200, R.string.ingEg1,)), R.string.recipe1
        )
        recipeList.add(recipe6)


        return recipeList
    }

}