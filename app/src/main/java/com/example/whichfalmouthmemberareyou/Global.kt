package com.example.whichfalmouthmemberareyou

import android.app.Application

class Global : Application() {

    var alex:   Int = 0;
    var amy:    Int = 0;
    var jack:   Int = 0;
    var sam:    Int = 0;
    var tom:    Int = 0;

    fun plusScore (person : String) {

        when (person) {
            "alex" -> this.alex += 1
            "amy" -> this.amy += 1
            "jack" -> this.jack += 1
            "sam" -> this.sam += 1
            "tom" -> this.tom += 1

            else -> {
                print("something went wrong")
            }
        }

    }

    fun printScore (person: String) {

        when (person) {
            "alex" -> println("Alex's Score = " + this.alex.toString())
            "amy" -> println("Amy's Score = " + this.amy.toString())
            "jack" -> println("Jack's Score = " + this.jack.toString())
            "sam" -> println("Sam's Score = " + this.sam.toString())
            "tom" -> println("Tom's Score = " + this.tom.toString())

            else -> {
                print("something went wrong")
            }
        }

    }

}