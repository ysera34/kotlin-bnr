const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {

    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal purchases $name ($type) with $price gold coin(s)."
    println(message)

    val phrase1 = "wow. $name is really good"
    println("Madrigal admires. ${toDragonSpeak(phrase1)}")

    val phrase2 = if (name == "Dragon's Breath") {
        "Madrigal admires. ${toDragonSpeak("wow. $name is really good")}"
    } else {
        "Madrigal says. Thanks $name."
    }
    println(phrase2)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
