import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie") // MutableList<String>
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

val uniquePatronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>) {

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)
    uniquePatrons.forEach {
        uniquePatronGold[it] = 6.0
        uniquePatronGold += it to 6.0
    }
    println(uniquePatronGold)

    var orderCount = 0
    while (uniquePatrons.isNotEmpty() && orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName purchases $name ($type) with $price gold coin(s)."
    println(message)
    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName admires. ${toDragonSpeak("wow. $name is really good")}"
    } else {
        "$patronName says. Thanks $name."
    }
    println(phrase)
}

private fun performPurchase(price: Double, patronName: String) {
    val totalPurse = uniquePatronGold.getValue(patronName)
    val remainingBalance = run {
        if (totalPurse - price >= 0) {
            println("Purchase the menu for $price")
            totalPurse - price
        } else {
            println("There is not enough gold coins.")
            totalPurse
        }
    }
    uniquePatronGold[patronName] = remainingBalance
}

private fun displayPatronBalances() {
    uniquePatronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
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
