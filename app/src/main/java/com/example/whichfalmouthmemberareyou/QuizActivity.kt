package com.example.whichfalmouthmemberareyou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class QuizActivity : AppCompatActivity() {

    val buttonList = ArrayList<Button>()
    val answerList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val button1View = findViewById<Button>(R.id.button1)
        val button2View = findViewById<Button>(R.id.button2)
        val button3View = findViewById<Button>(R.id.button3)
        val button4View = findViewById<Button>(R.id.button4)
        val button5View = findViewById<Button>(R.id.button5)

        buttonList.add(button1View)
        buttonList.add(button2View)
        buttonList.add(button3View)
        buttonList.add(button4View)
        buttonList.add(button5View)

        val alexList: Array<String> = resources.getStringArray(R.array.alex_answers)
        val amyList: Array<String> = resources.getStringArray(R.array.amy_answers)
        val jackList: Array<String> = resources.getStringArray(R.array.jack_answers)
        val samList: Array<String> = resources.getStringArray(R.array.sam_answers)
        val tomList: Array<String> = resources.getStringArray(R.array.tom_answers)

        new_question()

        for (button in buttonList) {
            button.setOnClickListener() {
                for (answer in alexList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("alex")
                        (applicationContext as Global).printScore("alex")
                    }
                }
                for (answer in amyList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("amy")
                        (applicationContext as Global).printScore("amy")
                    }
                }
                for (answer in jackList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("jack")
                        (applicationContext as Global).printScore("jack")
                    }
                }
                for (answer in samList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("sam")
                        (applicationContext as Global).printScore("sam")
                    }
                }
                for (answer in tomList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("tom")
                        (applicationContext as Global).printScore("tom")
                    }
                }
                new_question()
            }
        }
    }

    fun new_question() {

        if ((applicationContext as Global).atLeastTen()) {
            go_to_results()
        }

        else {

            val questionTextView = findViewById<TextView>(R.id.questionText)

            val questionList: Array<String> = resources.getStringArray(R.array.questions)

            val alexList: Array<String> = resources.getStringArray(R.array.alex_answers)
            val amyList: Array<String> = resources.getStringArray(R.array.amy_answers)
            val jackList: Array<String> = resources.getStringArray(R.array.jack_answers)
            val samList: Array<String> = resources.getStringArray(R.array.sam_answers)
            val tomList: Array<String> = resources.getStringArray(R.array.tom_answers)

            val rnd = Random()

            val questionNum = rnd.nextInt(questionList.size)
            questionTextView.setText(questionList[questionNum])
            //questionList.removeAt(questionNum)

            for (string in questionList) {
                println(string)
            }

            answerList.clear()
            answerList.add(alexList[questionNum])
            answerList.add(amyList[questionNum])
            answerList.add(jackList[questionNum])
            answerList.add(samList[questionNum])
            answerList.add(tomList[questionNum])

            for (button in buttonList) {

                val num = rnd.nextInt(answerList.size)
                button.setText(answerList.get(num))
                answerList.removeAt(num)
            }
        }
    }

    fun go_to_results () {

        val resultsIntent = Intent(this, ResultActivity::class.java)
        startActivity(resultsIntent)

    }
}