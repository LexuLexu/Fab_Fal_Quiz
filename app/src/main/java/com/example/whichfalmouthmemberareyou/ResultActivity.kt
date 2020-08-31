package com.example.whichfalmouthmemberareyou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.util.ResourceBundle.getBundle

class ResultActivity : AppCompatActivity() {

    private var mostLike = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if ((applicationContext as Global).areEqual()) {
            mostLike = "7 Falmouth Road"
        }

        else {
            (applicationContext as Global).sortMembers()
            (applicationContext as Global).returnMostSimilarMember()
            mostLike = (applicationContext as Global).getMostSimilar()
        }

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
            "7 Falmouth Road" -> resultImage.setImageDrawable(getDrawable(R.drawable.house_result))

        }

        when (mostLike) {

            "alex" -> sophieQuote.setText("Sophie says: \"" + quotesArray[0] + "\"")
            "amy" -> sophieQuote.setText("Sophie says: \"" + quotesArray[1] + "\"")
            "jack" -> sophieQuote.setText("Sophie says: \"" + quotesArray[2] + "\"")
            "sam" -> sophieQuote.setText("Sophie says: \"" + quotesArray[3] + "\"")
            "tom" -> sophieQuote.setText("Sophie says: \"" + quotesArray[4] + "\"")
            "7 Falmouth Road" -> sophieQuote.setText("Sophie says: \"" + quotesArray[5] + "\"")

        }

        when (mostLike) {

            "alex" -> description.setText(descArray[0])
            "amy" -> description.setText(descArray[1])
            "jack" -> description.setText(descArray[2])
            "sam" -> description.setText(descArray[3])
            "tom" -> description.setText(descArray[4])
            "7 Falmouth Road" -> description.setText(descArray[5])

        }

    }

}
