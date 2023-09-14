package com.example.tastebonanza.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tastebonanza.databinding.FragmentOnBoardingBinding
import com.example.tastebonanza.utilits.replaceFragmentMain

class OnBoardingFragment : Fragment() {
    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        binding.btLetsBegin.setOnClickListener { replaceFragmentMain(CreateEquipmentFragment()) }

        return binding.root
    }
}
