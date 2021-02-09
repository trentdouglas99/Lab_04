package com.csci448.trentdouglas.lab02.data
import android.util.Log
import androidx.lifecycle.ViewModel
import com.csci448.trentdouglas.lab02.R


// QuizMaster.kt
class QuizViewModel(private var currentQuestionIndex: Int, private var score: Int) : ViewModel() {
    private val questionBank: MutableList<Question> = mutableListOf()
    //private var score = 0
    //private val currentQuestionIndex = 0
    private val TAG = "QuizViewModel"



    init {
            Log.d(TAG, "ViewModel instance created")
            questionBank.add( Question(R.string.question1, false) )
            questionBank.add( Question(R.string.question2, true) )
            questionBank.add( Question(R.string.question3, true) )
            questionBank.add( Question(R.string.question4, false) )
            questionBank.add( Question(R.string.question5, true) )
    }

    override fun onCleared() {
        Log.d(TAG, "ViewModel instance about to be destroyed")
        super.onCleared()
    }


    private val currentQuestion: Question
        get() = questionBank[currentQuestionIndex]



    val currentIndex: Int
        get() = currentQuestionIndex

    val currentScore: Int
        get() = score

    val currentQuestionTextId: Int
        get() = currentQuestion.textResId
    val currentQuestionAnswer: Boolean
        get() = currentQuestion.isAnswerTrue


    fun isAnswerCorrect(answer: Boolean): Boolean{
        if (answer == currentQuestion.isAnswerTrue){
            score += 1
            return true
        }
        return false
    }

    fun moveToNextQuestion(){
        currentQuestionIndex = (currentQuestionIndex + 1)%questionBank.size
    }
    fun moveToPreviousQuestion(){
        if(currentQuestionIndex - 1 == -1){
            currentQuestionIndex = questionBank.size - 1
        }
        else{
            currentQuestionIndex = (currentQuestionIndex - 1)
        }

    }



}
