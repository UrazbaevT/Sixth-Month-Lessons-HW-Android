package com.example.a5month_lesson3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    val counter = MutableLiveData<Int>()
    private var mCount = 0

    fun onIncrementClick(){
        counter.value = ++mCount
    }

    fun onDecrementClick(){
        counter.value = --mCount
    }

}