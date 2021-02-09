package com.csci448.trentdouglas.lab02.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.csci448.trentdouglas.lab02.R
import com.csci448.trentdouglas.lab02.databinding.ActivityCheatBinding
import com.csci448.trentdouglas.lab02.databinding.ActivityQuizBinding
import com.csci448.trentdouglas.lab02.ui.quiz.QuizActivity

class CheatActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "448.CheatActivity"
    }

    private lateinit var binding: ActivityQuizBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)


    }

    public static fun createIntent(){

    }




}