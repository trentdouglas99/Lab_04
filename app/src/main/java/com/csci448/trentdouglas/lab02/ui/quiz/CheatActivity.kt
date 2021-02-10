package com.csci448.trentdouglas.lab02.ui.quiz

import android.app.Activity
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

    private var answerShown: Boolean = false

    private lateinit var binding: ActivityCheatBinding
    companion object {
        private const val LOG_TAG = "448.CheatActivity"

        private const val EXTRA_ANSWER_IS_TRUE = "CORRECT_ANSWER_KEY"
        private const val EXTRA_ANSWER_SHOWN = "ANSWER_SHOWN"

        fun didUserCheat(intent: Intent) = intent.getBooleanExtra(EXTRA_ANSWER_SHOWN, false)


        fun createIntent(packageContext: Context, answerIsTrue: Boolean): Intent{
            return Intent(packageContext, CheatActivity::class.java).apply{
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.d(LOG_TAG, "onSaveInstanceState")
        savedInstanceState.putBoolean(EXTRA_ANSWER_SHOWN, answerShown)

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onCreate() called")

        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val answer = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        answerShown = savedInstanceState?.getBoolean(EXTRA_ANSWER_SHOWN)?: false


        if(answerShown) {
            binding.answerView.visibility = View.VISIBLE
            val intent = Intent().apply{putExtra(EXTRA_ANSWER_SHOWN, true)}
            setResult(Activity.RESULT_OK, intent)

        }




        binding.answerView.text = answer.toString()

        binding.showAnswerButton.setOnClickListener {setCheated()}

    }

    private fun setCheated(){

        binding.answerView.visibility = View.VISIBLE
        answerShown = true
        val intent = Intent().apply{putExtra(EXTRA_ANSWER_SHOWN, true)}
        setResult(Activity.RESULT_OK, intent)
    }


}