package com.bignerdranch.nyethack

open class Weapon(val name: String, val type: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Weapon

        if (name != other.name) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}

fun main(args: Array<String>) {
    val weapon1 = Weapon("ebony kris", "dagger")
    val weapon2 = Weapon("ebony kris", "dagger")
    println(weapon1 == weapon2)
}
