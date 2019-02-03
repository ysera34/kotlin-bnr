fun main(args: Array<String>) {
    val player = Player().apply {
        castFireball(5)
        castFireball()
    }
//    player.castFireball(5)
//    player.castFireball()

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
