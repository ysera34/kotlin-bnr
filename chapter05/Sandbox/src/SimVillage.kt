fun main(args: Array<String>) {

    var lettersNumber = "Mississippi".count()
    println(lettersNumber)

    // Lambda argument should be moved out of parentheses
    lettersNumber = "Mississippi".count({ letter ->
        letter == 's'
    })
    println(lettersNumber)

    lettersNumber = "Mississippi".count { letter ->
        letter == 's'
    }
    println(lettersNumber)

    lettersNumber = "Mississippi".count {
        it == 's'
    }
    println(lettersNumber)


    // () -> kotlin.String
    println({
        val currentYear = 2019
        "Welcome to SimVillage, (copyright $currentYear)"
    })
    // Welcome to SimVillage, (copyright 2019)
    println({
        val currentYear = 2019
        "Welcome to SimVillage, (copyright $currentYear)"
    }())

    val greetingFunction1: () -> String = {
        val currentYear = 2019
        "Welcome to SimVillage, (copyright $currentYear)"
    }
    val greetingFunction2 = {
        val currentYear = 2019
        "Welcome to SimVillage, (copyright $currentYear)"
    }
    println(greetingFunction1)
    println(greetingFunction1())
    println(greetingFunction2)
    println(greetingFunction2())

    var greetingToPlayerFunction: (playerName: String) -> String = { playerName ->
        val currentYear = 2019
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingToPlayerFunction)
    println(greetingToPlayerFunction("james"))

    greetingToPlayerFunction = { it ->
        val currentYear = 2019
        "Welcome to SimVillage, $it! (copyright $currentYear)"
    }
    println(greetingToPlayerFunction)
    println(greetingToPlayerFunction("james"))

    val greetingToPlayerAndPrintInfoFunction1: (String, Int) -> String = { playerName, buildingsNumber ->
        println("$buildingsNumber buildings have been added.")
        val currentYear = 2019
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    val greetingToPlayerAndPrintInfoFunction2 = { playerName: String, buildingsNumber: Int ->
        println("$buildingsNumber buildings have been added.")
        val currentYear = 2019
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingToPlayerAndPrintInfoFunction1)
    println(greetingToPlayerAndPrintInfoFunction1("james", 2))
    println(greetingToPlayerAndPrintInfoFunction2)
    println(greetingToPlayerAndPrintInfoFunction2("james", 3))

    runSimulation1("james", greetingToPlayerAndPrintInfoFunction1)
    runSimulation1("james", greetingToPlayerAndPrintInfoFunction2)
    runSimulation1("james") { playerName, buildingsNumber ->
        println("$buildingsNumber buildings have been added.")
        val currentYear = 2019
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulation2("james", ::printConstructionCost) { playerName, buildingsNumber ->
        println("$buildingsNumber buildings have been added.")
        val currentYear = 2019
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulation3()
}

inline fun runSimulation1(playerName: String, greetingFunction: (String, Int) -> String) {
    val buildingsNumber = (1..3).shuffled().last()
    println(greetingFunction(playerName, buildingsNumber))
}

inline fun runSimulation2(
    playerName: String,
    costPrinter: (Int) -> Unit,
    greetingFunction: (String, Int) -> String
) {
    val buildingsNumber = (1..3).shuffled().last()
    costPrinter(buildingsNumber)
    println(greetingFunction(playerName, buildingsNumber))
}

fun runSimulation3() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("james"))
}

fun printConstructionCost(buildingsNumber: Int) {
    val cost = 500
    println("Construction Cost: ${cost * buildingsNumber}")
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "Hospital"
    var buildingsNumber = 5
    return { playerName: String ->
        val currentYear = 2019
        buildingsNumber += 1
        println("$buildingsNumber $structureType types have been added.")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}
