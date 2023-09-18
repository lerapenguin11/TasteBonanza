package com.example.tastebonanza.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tastebonanza.R
import com.example.tastebonanza.databinding.FragmentCreateEnjoyBinding
import com.example.tastebonanza.databinding.FragmentCreateEquipmentBinding
import com.example.tastebonanza.utilits.replaceFragmentMain
import com.example.tastebonanza.viewmodel.SettingsViewModel

class CreateEnjoyFragment : Fragment() {
    private var _binding : FragmentCreateEnjoyBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateEnjoyBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)

        binding.btNext.setOnClickListener {
            viewModel.getCode(1)
            replaceFragmentMain(CookFragment()) }

        binding.btBack.setOnClickListener { replaceFragmentMain(OnBoardingFragment()) }

        binding.box1.setOnClickListener { binding.tvLevel.setText(R.string.beginner) }
        binding.box2.setOnClickListener { binding.tvLevel.setText(R.string.study) }
        binding.box3.setOnClickListener { binding.tvLevel.setText(R.string.neutral) }
        binding.box4.setOnClickListener { binding.tvLevel.setText(R.string.good) }
        binding.box5.setOnClickListener { binding.tvLevel.setText(R.string.excellent) }

        return  binding.root
    }
}