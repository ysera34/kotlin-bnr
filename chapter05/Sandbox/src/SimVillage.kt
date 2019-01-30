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

    val greetingFunction: () -> String = {
        val currentYear = 2019
        "Welcome to SimVillage, (copyright $currentYear)"
    }
    println(greetingFunction)
    println(greetingFunction())

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

    val greetingToPlayerAndPrintInfoFunction: (String, Int) -> String = { playerName, buildingsNumber ->
        println("$buildingsNumber buildings have been added.")
        val currentYear = 2019
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingToPlayerAndPrintInfoFunction)
    println(greetingToPlayerAndPrintInfoFunction("james", 2))
}
