import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {

    placeOrder("shandy,Dragon's Breath,5.91")

    println(patronList)
    println(patronList[0])
    println(patronList.first())

    println(patronList[2])
    println(patronList.last())

    println(patronList.getOrElse(4) { "Unknown Patron" })
    println(patronList.getOrNull(4) ?: "Unknown Patron")

    if (patronList.contains("Eli")) {
        println("Taernyl owner talks. Eli is playing cards in the inner room.")
    } else {
        println("Taernyl owner talks. Eli is not here.")
    }

    if (patronList.containsAll(listOf("Mordoc", "Sophie"))) {
        println("Taernyl owner talks. Yes, it's all here.")
    } else {
        println("Taernyl owner talks. No, they all went out a few hours ago.")
    }
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal purchases $name ($type) with $price gold coin(s)."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal admires. ${toDragonSpeak("wow. $name is really good")}"
    } else {
        "Madrigal says. Thanks $name."
    }
    println(phrase)
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

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse amount: $totalPurse")
    val remainingBalance = totalPurse - price
    println("Purchase the drink for $price")
    println("Purse balance. ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

fun displayBalance() {
    println("The player's purse balance. Gold: $playerGold, Silver: $playerSilver")
}
