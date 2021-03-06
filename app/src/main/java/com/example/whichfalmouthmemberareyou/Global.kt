package com.example.whichfalmouthmemberareyou

import android.app.Application

class Global : Application() {

    private var alex:   Int = 0
    private var amy:    Int = 0
    private var jack:   Int = 0
    private var sam:    Int = 0
    private var tom:    Int = 0

    private val sortedList = ArrayList<Int>()

    private var mostLike = ""

    fun areEqual () : Boolean {
        return (alex == 2 && amy == 2 && jack == 2 && sam == 2 && tom == 2)
    }

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

    fun atLeastTen (): Boolean {

        return (this.alex + this.amy + this.jack + this.sam + this.tom) >= 10

    }

    fun sortMembers (): ArrayList<Int>  {

        sortedList.add(this.alex)
        sortedList.add(this.amy)
        sortedList.add(this.jack)
        sortedList.add(this.sam)
        sortedList.add(this.tom)

        sortedList.sort()

        return sortedList
    }

    fun returnMostSimilarMember () {

        when (sortedList[4]) {

            this.alex -> mostLike = "alex"
            this.amy -> mostLike = "amy"
            this.jack -> mostLike = "jack"
            this.sam -> mostLike = "sam"
            this.tom -> mostLike = "tom"
        }
    }

    fun getMostSimilar () : String {
        return mostLike
    }

    fun resetScores () {
        alex = 0
        amy = 0
        jack = 0
        sam = 0
        tom = 0
    }

}