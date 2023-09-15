package com.example.tastebonanza.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tastebonanza.R
import com.example.tastebonanza.databinding.FragmentCreateEquipmentBinding
import com.example.tastebonanza.databinding.FragmentCreateProcessBinding
import com.example.tastebonanza.utilits.replaceFragmentMain

class CreateProcessFragment : Fragment() {
    private var _binding : FragmentCreateProcessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateProcessBinding.inflate(inflater, container, false)

        binding.btNext.setOnClickListener { replaceFragmentMain(MainScreenFragment()) }

        return binding.root
    }
}