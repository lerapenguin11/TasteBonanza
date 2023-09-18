package com.example.tastebonanza.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tastebonanza.databinding.FragmentOnBoardingBinding
import com.example.tastebonanza.utilits.replaceFragmentMain
import com.example.tastebonanza.viewmodel.SettingsViewModel

class OnBoardingFragment : Fragment() {
    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)

        binding.btLetsBegin.setOnClickListener { replaceFragmentMain(CreateEquipmentFragment()) }

        return binding.root
    }
}
