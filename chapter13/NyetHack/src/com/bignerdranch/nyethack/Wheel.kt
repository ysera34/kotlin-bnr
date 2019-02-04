package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    val wheel = Wheel()
    wheel.printAlignment()
    wheel.initAlignment()
    wheel.printAlignment()
}

class Wheel {

    lateinit var alignment: String

    fun initAlignment() {
        alignment = "GOOD"
    }

    fun printAlignment() {
//        println(alignment) // UninitializedPropertyAccessException
        if (::alignment.isInitialized) {
            println(alignment)
        } else {
            println("The wheel has not been initialized yet.")
        }
    }
}
