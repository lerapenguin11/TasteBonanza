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

}