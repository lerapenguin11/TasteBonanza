package com.example.tastebonanza.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tastebonanza.business.model.Constants
import com.example.tastebonanza.business.model.Equipment
import com.example.tastebonanza.business.model.EquipmentModel
import com.example.tastebonanza.business.repos.EquipmentRepository

class EquipmentViewModel : ViewModel() {

    private val repository = EquipmentRepository()

    fun getResultEquipment(): LiveData<MutableList<EquipmentModel>> {
        val mutableData = MutableLiveData<MutableList<EquipmentModel>>()
        repository.getEquipmentListReading(Constants.getTrendingNews()).observeForever { list ->
            mutableData.value = list
        }

        return mutableData
    }
}