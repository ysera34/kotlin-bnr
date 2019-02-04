package com.bignerdranch.nyethack

/**
 * primary constructor
 */
class Player(_name: String,
    /*_healthPoints*/var healthPoints: Int = 100,
    /*_isBlessed*/val isBlessed: Boolean,
    /*_isImmortal*/private val isImmortal : Boolean) {

    /**
     * If you are using a custom getter setter,
     * you must define class properties
     * and constructor parameter that use temporary variables.
     */
    var name = _name
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    /**
     * Properties that use automatically generated default getters and setters
     * can be defined only in the primary constructor, not in the class itself.
     */
    /*var healthPoints = _healthPoints*/
    /*val isBlessed = _isBlessed*/
    /*private val isImmortal = _isImmortal*/

    /**
     * secondary constructor
     */
    constructor(name: String) : this(
        name,
        /*healthPoints = 100,*/ // using default value of primary constructor
        isBlessed = true,
        isImmortal = false
    ) {
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

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
