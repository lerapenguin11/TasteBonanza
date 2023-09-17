package com.example.tastebonanza.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tastebonanza.business.database.AppDatabase
import com.example.tastebonanza.business.database.EquipmentDao
import com.example.tastebonanza.business.database.RecipeDao
import com.example.tastebonanza.business.model.Equipment
import com.example.tastebonanza.business.model.Ingredients
import com.example.tastebonanza.business.model.Recipe
import com.example.tastebonanza.business.model.RecipeModel
import com.example.tastebonanza.databinding.FragmentCreateEquipmentBinding
import com.example.tastebonanza.presentation.adapter.EquipmentAdapter
import com.example.tastebonanza.utilits.replaceFragmentMain
import com.example.tastebonanza.viewmodel.EquipmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateEquipmentFragment : Fragment() {
    private var _binding : FragmentCreateEquipmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : EquipmentViewModel
    private val adapter = EquipmentAdapter()

    private lateinit var equipmentDao: EquipmentDao
    private lateinit var recipeDao: RecipeDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateEquipmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(EquipmentViewModel::class.java)

        equipmentDao = AppDatabase.getInstance(requireContext()).equipmentDao()
        recipeDao =  AppDatabase.getInstance(requireContext()).recipeDao()

        observeEquipmentData()
        binding.btNext.setOnClickListener {
            saveRecipeAll()
            saveChoice()
        }

        return  binding.root
    }

    private fun saveRecipeAll() {
        viewModel.getResultRecipeAll().observe(viewLifecycleOwner, Observer {
            for (recipeModel in it){
                CoroutineScope(Dispatchers.IO).launch {
                    recipeDao.insertRecipe(Recipe(name = recipeModel.name,
                        equipment = recipeModel.equipment.map { Equipment(name = it.name) },
                        iconList = recipeModel.iconList,
                        tag = recipeModel.tag,
                        icon = recipeModel.icon,
                        servings = recipeModel.servings,
                        time = recipeModel.time,
                        calories = recipeModel.calories,
                        ingredients = recipeModel.ingredients.map { Ingredients(ingredientName = it.ingredientName,
                            ingredientCount = it.ingredientCount,
                            ingredientEd = it.ingredientEd) },
                        recipe = recipeModel.recipe))
                }
            }
        })
    }

    private fun saveChoice() {
        val selectedEquipment = mutableListOf<Int>()
        val checkedItemPositions = adapter.getSelectedEquipment()

        for (i in checkedItemPositions) {
            val equipment = i.name
            selectedEquipment.add(equipment)
        }

        for (equipment in selectedEquipment) {
            CoroutineScope(Dispatchers.IO).launch {
                equipmentDao.insertEquipment(Equipment(name = equipment))
            }
        }
        replaceFragmentMain(CreateEnjoyFragment())
    }

    private fun observeEquipmentData() {
        binding.rvEquipment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvEquipment.adapter = adapter

        viewModel.getResultEquipment().observe(viewLifecycleOwner, Observer { list ->
            adapter.setItem(list)
        })
    }
}