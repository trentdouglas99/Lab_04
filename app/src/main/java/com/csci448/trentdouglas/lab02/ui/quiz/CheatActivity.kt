package com.csci448.trentdouglas.lab02.ui.quiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.csci448.trentdouglas.lab02.R
import com.csci448.trentdouglas.lab02.databinding.ActivityCheatBinding
import com.csci448.trentdouglas.lab02.databinding.ActivityQuizBinding
import com.csci448.trentdouglas.lab02.ui.quiz.QuizActivity

class CheatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheatBinding
    companion object {
        private const val LOG_TAG = "448.CheatActivity"

        private const val EXTRA_ANSWER_IS_TRUE = "CORRECT_ANSWER_KEY"

        fun createIntent(packageContext: Context, answerIsTrue: Boolean): Intent{
            return Intent(packageContext, CheatActivity::class.java).apply{
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }




    }




    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onCreate() called")

        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val answer = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        Log.d(LOG_TAG, answer.toString())

        binding.answerView.setText(answer.toString())

        binding.showAnswerButton.setOnClickListener {binding.answerView.setVisibility(View.VISIBLE)}

    }


}