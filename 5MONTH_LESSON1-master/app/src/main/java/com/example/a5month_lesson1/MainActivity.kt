package com.example.a5month_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5month_lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imageUrls = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list()
        initListener()
    }

    private fun initListener() {
        binding.submitButton.setOnClickListener {
            val imageUrl = binding.editText.toString()
            imageUrls.add(imageUrl)
            binding.editText.text.clear()
        }

        binding.randomButton.setOnClickListener {
            val random = java.util.Random()
            val index = random.nextInt(imageUrls.size)
            val imageUrl = imageUrls[index]

            binding.imageView.loadImage(imageUrl)
        }
    }

    private fun list() {
        imageUrls.add("https://img.localway.ru/scaled/guide/4/480157/820x0.jpg")
        imageUrls.add("https://aif-s3.aif.ru/images/006/040/7041fa8c01a16ef45dc0c2fc801f02d8.jpg")
        imageUrls.add("https://img.localway.ru/scaled/guide/4/480156/820x0.jpg")
        imageUrls.add("https://www.culture.ru/s/tretyakovgallery/images/tild6564-3939-4331-a136-386462363165____.jpg")
        imageUrls.add("https://www.tg-m.ru/img/mag/2005/3/art_08_03_01.jpg")
    }
}
