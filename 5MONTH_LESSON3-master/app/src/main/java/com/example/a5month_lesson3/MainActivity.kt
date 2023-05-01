package com.example.a5month_lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.a5month_lesson3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel?.counter?.observe(this){
            binding.tvTitle.text = it.toString()
        }

        binding.btnPlus?.setOnClickListener {
            viewModel?.onIncrementClick()
        }

        binding.btnMinus?.setOnClickListener {
            viewModel?.onDecrementClick()
        }

    }
}