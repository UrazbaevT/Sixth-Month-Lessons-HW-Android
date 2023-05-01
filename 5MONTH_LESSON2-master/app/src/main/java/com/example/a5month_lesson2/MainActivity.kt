package com.example.a5month_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5month_lesson2.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = mutableListOf<Double>()
    //List, ArrayList, LinkedList, HashMap, HashSet, Set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnAdd.setOnClickListener {
                if (editText.text.isNotEmpty()) {
                    list.add(sqrt(editText.text.toString().toDouble()))
                    editText.text.clear()
                }
            }

            btnOutput.setOnClickListener {
//            if (Math.sqrt())
                tvResult.text = list.toString()
            }
        }
    }

}