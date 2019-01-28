fun main(args: Array<String>) {
    val name = "mardregal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    printPlayerStatus(
        auraColor = "NONE",
        isBlessed = true,
        name = "mardregal",
        healthStatus = "is best state")
    castFireball(5)
    castFireball()
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
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


private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    return if (auraVisible) "GREEN" else "NONE"
}

private fun castFireball(numFireballs: Int = 2) = // default argument
    println("A bunch of fireballs appear. (x$numFireballs)")
