package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityConjunctionTableBinding
import kotlinx.android.synthetic.main.activity_conjunction_table.*

class ConjunctionTableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConjunctionTableBinding
    val MAX_ANSWERS_LIMIT: Int = 4
    var answers: MutableList<String> = mutableListOf<String>()
    var correctAnswersCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConjunctionTableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        submitBtn.setOnClickListener {
            onSubmit()
        }
    }

    private fun onSubmit() {
        answers.add(binding.answerRow1.text.toString())
        answers.add(binding.answerRow2.text.toString())
        answers.add(binding.answerRow3.text.toString())
        answers.add(binding.answerRow4.text.toString())
        var i: Int = 0
        for(answer in answers) {
            if(!isValidAnswer(answer)) {
                break
            } else {
                isCorrectAnswer(answer, i)
            }
            i++
        }
        if (i == MAX_ANSWERS_LIMIT) {
            Toast.makeText(this, "You have " + correctAnswersCount + " correct answers and " +
                    (MAX_ANSWERS_LIMIT - correctAnswersCount) + " incorrect answers.", Toast.LENGTH_LONG).show()
        }

        i = 0;
        answers.clear()
        correctAnswersCount = 0
    }

    private fun isValidAnswer(answer: String): Boolean {
        if(answer == "T" || answer == "F") {
            return true;
        } else {
            Toast.makeText(this, "Invalid answer filled in, " +
                    "please fill in T(true) or F(false) as answer",
                Toast.LENGTH_LONG).show()
            return false
        }
    }

    private fun isCorrectAnswer(answer: String, rowNumber: Int) {
        when(rowNumber) {
            0 -> if(answer == "T") correctAnswersCount++
            1 -> if(answer == "F") correctAnswersCount++
            2 -> if(answer == "F") correctAnswersCount++
            3 -> if(answer == "F") correctAnswersCount++
        }
    }

}