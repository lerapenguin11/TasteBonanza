package com.example.tastebonanza.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tastebonanza.R
import com.example.tastebonanza.databinding.FragmentCreateEnjoyBinding
import com.example.tastebonanza.databinding.FragmentCreateEquipmentBinding
import com.example.tastebonanza.utilits.replaceFragmentMain

class CreateEnjoyFragment : Fragment() {
    private var _binding : FragmentCreateEnjoyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateEnjoyBinding.inflate(inflater, container, false)

        binding.btNext.setOnClickListener { replaceFragmentMain(CookFragment()) }

        return  binding.root
    }
}