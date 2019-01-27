fun main(args: Array<String>) {
    val name = "mardregal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

//    if (isBlessed && healthPoints > 50 || isImmortal) {
    if (auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }
    var auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    auraColor = when (karma) {
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        in 16..20 -> "GREEN"
        else -> "NONE"
    }
    if (auraVisible) {
        println(auraColor)
    }

    if (healthPoints == 100) {
        println(name + " is best state")
    } else if (healthPoints >= 90) {
        println(name + " has only a few abrasions.")
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            println(name + " had minor injuries but soon healed.")
        } else {
            println(name + " has only minor injuries.")
        }
    } else if (healthPoints >= 15) {
        println(name + " seems to be hurt a lot.")
    } else {
        println(name + " is worst state")
    }

    var healthStatus = if (healthPoints == 100) {
        " is best state"
    } else if (healthPoints >= 90) {
        " has only a few abrasions."
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            " had minor injuries but soon healed."
        } else {
            " has only minor injuries."
        }
    } else if (healthPoints >= 15) {
        " seems to be hurt a lot."
    } else {
        " is worst state"
    }

    println(name + healthStatus)

    var arrowsInQuiver = 2
    if (arrowsInQuiver >= 5) {
        println("Sufficient arrows.")
        println("Can not have more arrows.")
    }
    if (arrowsInQuiver >= 5)
        println("Sufficient arrows.")
    println("Can not have more arrows.")

    healthStatus = if (healthPoints == 100) {
        " is best state"
    } else if (healthPoints in 90..99) {
        " has only a few abrasions."
    } else if (healthPoints in 75..89) {
        if (isBlessed) {
            " had minor injuries but soon healed."
        } else {
            " has only minor injuries."
        }
    } else if (healthPoints in 15..74) {
        " seems to be hurt a lot."
    } else {
        " is worst state"
    }

    println(name + healthStatus)

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> ""
    }

    healthStatus = when (healthPoints) {
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

    println(name + healthStatus)

    val statusFormatString = "(HP: $healthPoints)(Aura: $auraColor) -> $healthStatus"
    println(statusFormatString)
}
