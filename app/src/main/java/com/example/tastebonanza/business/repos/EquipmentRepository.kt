package com.example.tastebonanza.business.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tastebonanza.business.model.Equipment
import com.example.tastebonanza.business.model.EquipmentModel

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
}