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
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

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

    val healthStatus = if (healthPoints == 100) {
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
}
