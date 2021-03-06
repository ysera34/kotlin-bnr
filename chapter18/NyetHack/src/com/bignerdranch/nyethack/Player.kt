package com.bignerdranch.nyethack

import java.io.File
import com.bignerdranch.nyethack.extensions.random as randomizer

/**
 * primary constructor
 */
class Player(
    _name: String,
    /*_healthPoints*/override var healthPoints: Int = 100,
    /*_isBlessed*/val isBlessed: Boolean,
    /*_isImmortal*/private val isImmortal: Boolean
) : Fightable {
    override val diceCount: Int = 3
    override val diceSides: Int = 6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }

    /**
     * If you are using a custom getter setter,
     * you must define class properties
     * and constructor parameter that use temporary variables.
     */
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        set(value) {
            field = value.trim()
        }

    val hometown by lazy { selectHometown() }

    var currentPosition = Coordinate(0, 0)

    /**
     * Properties that use automatically generated default getters and setters
     * can be defined only in the primary constructor, not in the class itself.
     */
    /*var healthPoints = _healthPoints*/
    /*val isBlessed = _isBlessed*/
    /*private val isImmortal = _isImmortal*/

    /**
     * initializer block, check property value
     */
    init {
        require(healthPoints > 0) { "healthPoints must be greater than zero." }
        require(name.isNotBlank()) { "player must have a name." }
    }

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

    class PlayerScore1(val experience: Int, val level: Int) {
        operator fun component1() = experience
        operator fun component2() = level
    }

    data class PlayerScore2(val experience: Int, val level: Int)

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .randomizer()

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

fun main(args: Array<String>) {
    val (vExperience1, vLevel1) = Player.PlayerScore1(1250, 5)
    println("vExperience1 = $vExperience1, vLevel1 = $vLevel1")

    val (vExperience2, vLevel2) = Player.PlayerScore2(1250, 5)
    println("vExperience2 = $vExperience2, vLevel2 = $vLevel2")
}
