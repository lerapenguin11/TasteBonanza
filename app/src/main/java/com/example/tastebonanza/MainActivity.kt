package com.example.tastebonanza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tastebonanza.databinding.ActivityMainBinding
import com.example.tastebonanza.utilits.APP_ACTIVITY
import com.example.tastebonanza.utilits.setStatusBarGradiantMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setStatusBarGradiantMain(this)
        setContentView(binding.root)
    }
}