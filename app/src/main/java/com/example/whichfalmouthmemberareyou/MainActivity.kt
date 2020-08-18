package com.example.whichfalmouthmemberareyou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun go_to_quiz (view: View) {

        val quizIntent = Intent(this, QuizActivity::class.java)
        startActivity(quizIntent)

    }
}
