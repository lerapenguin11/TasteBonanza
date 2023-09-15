package com.example.tastebonanza.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tastebonanza.databinding.FragmentSplashBinding
import com.example.tastebonanza.utilits.replaceFragmentMain
import com.example.tastebonanza.viewmodel.SettingsViewModel

class SplashFragment : Fragment() {
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)

        val code = viewModel.codeSher.getInt("code", 0)

        Handler(Looper.getMainLooper()).postDelayed({
                                                    getCheck(code)
        }, 3000)

        return binding.root
    }

    private fun getCheck(code: Int) {
        if (code == 1){
            replaceFragmentMain(MainScreenFragment())
        } else{
            replaceFragmentMain(OnBoardingFragment())
        }
    }
}