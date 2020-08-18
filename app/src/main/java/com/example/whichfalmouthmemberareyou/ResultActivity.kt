package com.example.whichfalmouthmemberareyou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    var mostLike = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        (applicationContext as Global).sortMembers()
        (applicationContext as Global).returnMostSimilarMember()
        mostLike = (applicationContext as Global).get_mostLike()

        val resultText = findViewById<TextView>(R.id.resultTextView)
        resultText.setText(mostLike.capitalize())

        val resultImage = findViewById<ImageView>(R.id.resultImage)

        when (mostLike) {

            "alex" -> resultImage.setImageDrawable(getDrawable(R.drawable.alex_result))
            "amy" -> resultImage.setImageDrawable(getDrawable(R.drawable.amy_result))
            "jack" -> resultImage.setImageDrawable(getDrawable(R.drawable.jack_result))
            "sam" -> resultImage.setImageDrawable(getDrawable(R.drawable.sam_result))
            "tom" -> resultImage.setImageDrawable(getDrawable(R.drawable.tom_result))

        }

    }
}
