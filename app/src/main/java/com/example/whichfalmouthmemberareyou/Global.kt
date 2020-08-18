package com.example.whichfalmouthmemberareyou

import android.app.Application

class Global : Application() {

    var alex:   Int = 0
    var amy:    Int = 0
    var jack:   Int = 0
    var sam:    Int = 0
    var tom:    Int = 0

    val sortedList = ArrayList<Int>()

    var mostLike = ""

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

    fun get_mostLike () : String {
        return mostLike
    }

}