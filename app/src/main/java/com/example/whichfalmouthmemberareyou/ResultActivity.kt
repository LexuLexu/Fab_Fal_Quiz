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
        val sophieQuote = findViewById<TextView>(R.id.sophieQuote)
        val description = findViewById<TextView>(R.id.descriptions)

        val quotesArray: Array<String> = resources.getStringArray(R.array.sophie_quotes)
        val descArray: Array<String> = resources.getStringArray(R.array.descriptions)

        when (mostLike) {

            "alex" -> resultImage.setImageDrawable(getDrawable(R.drawable.alex_result))
            "amy" -> resultImage.setImageDrawable(getDrawable(R.drawable.amy_result))
            "jack" -> resultImage.setImageDrawable(getDrawable(R.drawable.jack_result))
            "sam" -> resultImage.setImageDrawable(getDrawable(R.drawable.sam_result))
            "tom" -> resultImage.setImageDrawable(getDrawable(R.drawable.tom_result))

        }

        when (mostLike) {

            "alex" -> sophieQuote.setText("Sophie says: \"" + quotesArray[0] + "\"")
            "amy" -> sophieQuote.setText("Sophie says: \"" + quotesArray[1] + "\"")
            "jack" -> sophieQuote.setText("Sophie says: \"" + quotesArray[2] + "\"")
            "sam" -> sophieQuote.setText("Sophie says: \"" + quotesArray[3] + "\"")
            "tom" -> sophieQuote.setText("Sophie says: \"" + quotesArray[4] + "\"")

        }

        when (mostLike) {

            "alex" -> description.setText(descArray[0])
            "amy" -> description.setText(descArray[1])
            "jack" -> description.setText(descArray[2])
            "sam" -> description.setText(descArray[3])
            "tom" -> description.setText(descArray[4])

        }

    }
}
