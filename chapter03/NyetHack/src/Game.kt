fun main(args: Array<String>) {
    val name = "mardregal"
    var healthPoints = 89
    val isBlessed = true

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
}
