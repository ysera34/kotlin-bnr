import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {

    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("shandy,Dragon's Breath,5.91")
//    placeOrder("elixir,Shirley's Temple,4.12")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal purchases $name ($type) with $price gold coin(s)."
    println(message)

    val purchaseResult = performPurchase(price.toDouble())

    if (purchaseResult) {
        val phrase = if (name == "Dragon's Breath") {
            "Madrigal admires. ${toDragonSpeak("wow. $name is really good")}"
        } else {
            "Madrigal says. Thanks $name."
        }
        println(phrase)
    }
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

fun performPurchase(price: Double): Boolean {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse amount: $totalPurse")
    val remainingBalance = run {
        if (totalPurse - price >= 0) {
            println("Purchase the drink for $price")
            totalPurse - price
        } else {
            println("There is not enough gold coins.")
            totalPurse
        }
    }
    println("Purse balance. ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()

    return totalPurse != remainingBalance
}

fun displayBalance() {
    println("The player's purse balance. Gold: $playerGold, Silver: $playerSilver")
}
