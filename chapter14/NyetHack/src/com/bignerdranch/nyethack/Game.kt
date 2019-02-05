package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    val player = Player("Madrigal", 89, true, false).apply {
        castFireball(5)
        castFireball()
    }
    val secondaryPlayer = Player("Kar")
    println("${secondaryPlayer.name}'s healthPoints: ${secondaryPlayer.healthPoints}")

    var currentRoom = Room("Foyer")
    println(currentRoom.description())
    println(currentRoom.load())

    println(currentRoom is Room) // true
    println(currentRoom is TownSquare) // false

    currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    println(currentRoom is Room) // true
    println(currentRoom is TownSquare) // true

    printPlayerStatus(player)

    performCombat()
    performCombat("Ulrich")
    performCombat("Hildr", true)
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}

fun performCombat() {
    println("There is no enemy.")
}

fun performCombat(enemyName: String) {
    println("Begins battle with the $enemyName")
}

fun performCombat(enemyName: String, isBlessed: Boolean) {
    if (isBlessed) {
        println("Begins battle with the $enemyName. Blessed.")
    } else {
        println("Begins battle with the $enemyName")
    }
}

fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if (any is Player) {
        any.isBlessed
    } else {
        (any as Room).name == "Fount of Blessings"
    }

    println("$any is a source of blessings: $isSourceOfBlessings")
}
