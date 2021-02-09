package com.csci448.trentdouglas.lab02.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// QuizViewModelFactory.kt
class QuizViewModelFactory(private val currentIndex: Int, private val currentScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Int::class.java, Int::class.java).newInstance(currentIndex, currentScore)
    }
}