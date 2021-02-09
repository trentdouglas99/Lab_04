package com.csci448.trentdouglas.lab02.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.csci448.trentdouglas.lab02.R
import com.csci448.trentdouglas.lab02.data.QuizViewModel
import com.csci448.trentdouglas.lab02.data.QuizViewModelFactory
import com.csci448.trentdouglas.lab02.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    companion object {
        private const val LOG_TAG = "448.QuizActivity"
        private const val KEY_INDEX = "index"
        private const val KEY_SCORE = "score"
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.d(LOG_TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX, quizViewModel.currentIndex)
        savedInstanceState.putInt(KEY_SCORE, quizViewModel.currentScore)
    }


    private lateinit var quizViewModel: QuizViewModel

    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onCreate() called")


        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0

        val currentScore = savedInstanceState?.getInt(KEY_SCORE, 0) ?: 0




        val factory = QuizViewModelFactory(currentIndex, currentScore) // start with the first question and no score
        quizViewModel = ViewModelProvider(this@QuizActivity, factory).get(QuizViewModel::class.java)

        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateQuestion();

        binding.trueButton.setOnClickListener { checkAnswer(true) }
        binding.falseButton.setOnClickListener { checkAnswer(false) }

        binding.nextButton.setOnClickListener { moveToQuestion(1) }
        binding.previousButton.setOnClickListener { moveToQuestion(-1) }
        binding.cheatButton.setOnClickListener { launchCheat() }

    }

    override fun onStart() {
        Log.d(LOG_TAG, "onStart() called")
        super.onStart()
    }

    override fun onResume() {
        Log.d(LOG_TAG, "onResume() called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(LOG_TAG, "onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LOG_TAG, "onStop() called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(LOG_TAG, "onDestroy() called")
        super.onDestroy()
    }

    private fun moveToQuestion(direction: Int){
        if(direction >= 0){
            quizViewModel.moveToNextQuestion()
        }
        else if(direction < 0){
            quizViewModel.moveToPreviousQuestion()
        }
        updateQuestion()
    }

    private fun updateQuestion(){
        //1. Set the text of the score TextView (score_text_view)
        //2. Set the text of the question TextView (question_text_view)

        setCurrentScoreText()

        binding.questionTextView.text = getString( quizViewModel.currentQuestionTextId )

    }

    private fun setCurrentScoreText() {
        binding.scoreTextView.text = quizViewModel.currentScore.toString()
    }

    private fun checkAnswer(answer: Boolean){
        if(quizViewModel.isAnswerCorrect(answer)){
            Toast.makeText(baseContext, R.string.correct_toast, Toast.LENGTH_SHORT).show()
            setCurrentScoreText()
        }
        else{
            Toast.makeText(baseContext, R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
        }
    }


    private fun launchCheat(){
        val intent = Intent(baseContext, CheatActivity::class.java)
        startActivity(intent)

    }

}
