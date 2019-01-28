fun main(args: Array<String>) {
    val name = "mardregal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")

    var arrowsInQuiver = 2
    if (arrowsInQuiver >= 5) {
        println("Sufficient arrows.")
        println("Can not have more arrows.")
    }
    if (arrowsInQuiver >= 5)
        println("Sufficient arrows.")
    println("Can not have more arrows.")

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> ""
    }

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    println(name + healthStatus)
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    return when (healthPoints) {
        100 -> " is best state"
        in 90..99 -> " has only a few abrasions."
        in 75..89 -> if (isBlessed) {
            " had minor injuries but soon healed."
        } else {
            " has only minor injuries."
        }
        in 15..74 -> " seems to be hurt a lot."
        else -> " is worst state"
    }
}
