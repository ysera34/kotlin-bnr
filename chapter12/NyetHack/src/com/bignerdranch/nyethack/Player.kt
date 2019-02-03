package com.bignerdranch.nyethack

class Player {
    var name = "mardregal"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false

    fun castFireball(numFireballs: Int = 2) = // default argument
        println("A bunch of fireballs appear. (x$numFireballs)")

    fun formatHealthStatus() =
        when (healthPoints) {
            100 -> "is best state"
            in 90..99 -> "has only a few abrasions."
            in 75..89 -> if (isBlessed) {
                "had minor injuries but soon healed."
            } else {
                "has only minor injuries."
            }
            in 15..74 -> "seems to be hurt a lot."
            else -> "is worst state"
        }

    fun auraColor() = if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"
}
