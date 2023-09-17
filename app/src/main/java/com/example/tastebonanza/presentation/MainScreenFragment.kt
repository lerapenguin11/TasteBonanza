package com.example.tastebonanza.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tastebonanza.R
import com.example.tastebonanza.business.database.AppDatabase
import com.example.tastebonanza.business.database.EquipmentDao
import com.example.tastebonanza.business.database.RecipeDao
import com.example.tastebonanza.business.model.Equipment
import com.example.tastebonanza.databinding.FragmentMainScreenBinding
import com.example.tastebonanza.presentation.adapter.RecipeAdapter
import com.example.tastebonanza.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenFragment : Fragment() {
    private var _binding : FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter : RecipeAdapter
    private lateinit var recipeDao: RecipeDao
    private lateinit var equipmentDao : EquipmentDao
    private lateinit var list : List<Int>
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application = requireActivity().application)
        ).get(MainViewModel::class.java)

        adapter = RecipeAdapter(requireContext())

        recipeDao = AppDatabase.getInstance(requireContext()).recipeDao()
        equipmentDao = AppDatabase.getInstance(requireContext()).equipmentDao()

        tt()
        return binding.root
    }

    fun tt (){
        viewModel.getAllEquipment().observe(viewLifecycleOwner, Observer {
            list = it

            val selectedEquipment = list
            viewModel.getRecipeFilter(selectedEquipment).observe(viewLifecycleOwner, Observer {recipes ->
                binding.rvRecipe.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvRecipe.adapter = adapter

                adapter.setItem(recipes)
            })
        })

    }
}