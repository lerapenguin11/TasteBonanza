package com.example.tastebonanza.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tastebonanza.business.database.AppDatabase
import com.example.tastebonanza.business.model.Equipment
import com.example.tastebonanza.business.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) : AndroidViewModel(application){
    private val equipmentDao = AppDatabase.getInstance(context = application).equipmentDao()
    private val recipeDao = AppDatabase.getInstance(context = application).recipeDao()

    //val list = equipmentDao.getAllEquipment()

    val equipmentListLiveData: MutableLiveData<List<Int>> = MutableLiveData()

    val recipeListLiveData : MutableLiveData<MutableList<Recipe>> = MutableLiveData()

    fun getAllEquipment(): LiveData<List<Int>> {
        viewModelScope.launch {
            val equipmentList = withContext(Dispatchers.IO) {
                equipmentDao.getAllEquipment().map { it.name }
            }
            equipmentListLiveData.postValue(equipmentList)
        }
        return equipmentListLiveData
    }

    fun getRecipeFilter(selectedEquipment : List<Int>): MutableLiveData<MutableList<Recipe>> {
        viewModelScope.launch {

            val recipes = withContext(Dispatchers.IO){
                recipeDao.getRecipesByEquipment(selectedEquipment.first())
            }
            recipeListLiveData.postValue(recipes)

        }
        return recipeListLiveData
    }
}