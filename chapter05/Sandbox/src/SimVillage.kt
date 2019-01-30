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
}