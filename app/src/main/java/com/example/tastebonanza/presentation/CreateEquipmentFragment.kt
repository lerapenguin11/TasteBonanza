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
import com.example.tastebonanza.business.model.Constants
import com.example.tastebonanza.databinding.FragmentCreateEquipmentBinding
import com.example.tastebonanza.databinding.FragmentSplashBinding
import com.example.tastebonanza.utilits.replaceFragmentMain
import com.example.tastebonanza.viewmodel.EquipmentViewModel

class CreateEquipmentFragment : Fragment() {
    private var _binding : FragmentCreateEquipmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : EquipmentViewModel
    private val adapter = EquipmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateEquipmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(EquipmentViewModel::class.java)

        observeEquipmentData()

        binding.btNext.setOnClickListener { replaceFragmentMain(CreateEnjoyFragment()) }

        return  binding.root
    }

    private fun observeEquipmentData() {
        binding.rvEquipment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvEquipment.adapter = adapter

        viewModel.getResultEquipment().observe(viewLifecycleOwner, Observer { list ->
            adapter.setItem(list)
        })
    }
}