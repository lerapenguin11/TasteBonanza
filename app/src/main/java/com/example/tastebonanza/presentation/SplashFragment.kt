package com.example.tastebonanza.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tastebonanza.R
import com.example.tastebonanza.databinding.FragmentSplashBinding
import com.example.tastebonanza.utilits.replaceFragmentMain

class SplashFragment : Fragment() {
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
                                                    replaceFragmentMain(OnBoardingFragment())
        }, 3000)

        return binding.root
    }

}