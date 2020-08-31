package com.example.whichfalmouthmemberareyou

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class QuizActivity : AppCompatActivity() {

    private val buttonList = ArrayList<Button>()
    private val answerList = ArrayList<String>()

    private lateinit var questionList: Array<String>
    private lateinit var pictureList: Array<Int>

    lateinit var alexList: Array<String>
    lateinit var amyList: Array<String>
    lateinit var jackList: Array<String>
    lateinit var samList: Array<String>
    lateinit var tomList: Array<String>

    private var questionNum = 0

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

        initializeLists()

        new_question()

        for (button in buttonList) {
            button.setOnClickListener {
                for (answer in alexList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("alex")
                        (applicationContext as Global).printScore("alex")
                        alexList = removeQ(alexList, questionNum)
                        amyList = removeQ(amyList, questionNum)
                        jackList = removeQ(jackList, questionNum)
                        samList = removeQ(samList, questionNum)
                        tomList = removeQ(tomList, questionNum)

                    }
                }
                for (answer in amyList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("amy")
                        (applicationContext as Global).printScore("amy")
                        alexList = removeQ(alexList, questionNum)
                        amyList = removeQ(amyList, questionNum)
                        jackList = removeQ(jackList, questionNum)
                        samList = removeQ(samList, questionNum)
                        tomList = removeQ(tomList, questionNum)

                    }
                }
                for (answer in jackList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("jack")
                        (applicationContext as Global).printScore("jack")
                        alexList = removeQ(alexList, questionNum)
                        amyList = removeQ(amyList, questionNum)
                        jackList = removeQ(jackList, questionNum)
                        samList = removeQ(samList, questionNum)
                        tomList = removeQ(tomList, questionNum)

                    }
                }
                for (answer in samList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("sam")
                        (applicationContext as Global).printScore("sam")
                        alexList = removeQ(alexList, questionNum)
                        amyList = removeQ(amyList, questionNum)
                        jackList = removeQ(jackList, questionNum)
                        samList = removeQ(samList, questionNum)
                        tomList = removeQ(tomList, questionNum)

                    }
                }
                for (answer in tomList) {
                    if (answer.equals(button.getText().toString())) {
                        (applicationContext as Global).plusScore("tom")
                        (applicationContext as Global).printScore("tom")
                        alexList = removeQ(alexList, questionNum)
                        amyList = removeQ(amyList, questionNum)
                        jackList = removeQ(jackList, questionNum)
                        samList = removeQ(samList, questionNum)
                        tomList = removeQ(tomList, questionNum)

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
            val pictureView = findViewById<ImageView>(R.id.pictureView)

            val rnd = Random()

            questionNum = rnd.nextInt(questionList.size)
            questionTextView.setText(questionList[questionNum])

            var pic: Drawable = getDrawable(pictureList[questionNum])
            pictureView.setImageDrawable(pic)

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

            questionList = removeQ(questionList, questionNum)
            pictureList = removeP(pictureList, questionNum)

            for (string in questionList) {
                println(string)
            }
            for (string in alexList) {
                println(string)
            }
        }
    }

    fun go_to_results () {

        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)

    }

    fun removeQ(arr: Array<String>, index: Int): Array<String> {
        if (index < 0 || index >= arr.size) {
            return arr
        }

        val result = arr.toMutableList()
        result.removeAt(index)
        return result.toTypedArray()
    }

    fun removeP(arr: Array<Int>, index: Int): Array<Int> {
        if (index < 0 || index >= arr.size) {
            return arr
        }

        val result = arr.toMutableList()
        result.removeAt(index)
        return result.toTypedArray()
    }

    fun initializeLists () {

        questionList = resources.getStringArray(R.array.questions)
        pictureList = arrayOf(
            R.drawable.cameo,
            R.drawable.exam,
            R.drawable.no_frisbee,
            R.drawable.seven_pm,
            R.drawable.breakfast,
            R.drawable.holiday,
            R.drawable.injury,
            R.drawable.spirit_animal,
            R.drawable.universe_point,
            R.drawable.beverage,
            R.drawable.outfit,
            R.drawable.book_genre,
            R.drawable.dream,
            R.drawable.song,
            R.drawable.greatest_achievement,
            R.drawable.role_model)

        alexList = resources.getStringArray(R.array.alex_answers)
        amyList = resources.getStringArray(R.array.amy_answers)
        jackList = resources.getStringArray(R.array.jack_answers)
        samList = resources.getStringArray(R.array.sam_answers)
        tomList = resources.getStringArray(R.array.tom_answers)



    }



}