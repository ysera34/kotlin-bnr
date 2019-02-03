import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie") // MutableList<String>
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val goodLookingMenuList = menuList.toMutableList()

//val patronGold: Map<String, Double> = mapOf("Eli".to(10.5), "Mordoc".to(8.0), "Sophie".to(5.5))
//val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
val patronGold = mapOf(
    Pair("Eli", 10.5),
    Pair("Mordoc", 8.0),
    Pair("Sophie", 5.5)
)
val uniquePatronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>) {

    val readOnlyPatronList = patronList.toList()
    val (goldMedalWinner, _, bronzeMedalWinner) = readOnlyPatronList
    println("Gold Medal Winner: $goldMedalWinner")
    println("Bronze Medal Winner: $bronzeMedalWinner")

    goodLookingMenuList.apply {
        var longestMenuNameLength = 0
        this.forEach {
            val menuData = it.split(',')
            if (longestMenuNameLength < menuData[1].length + menuData[2].length) {
                longestMenuNameLength = menuData[1].length + menuData[2].length
            }
        }
        longestMenuNameLength += 12
        this.forEachIndexed { index, menu ->
            val menuData = menu.split(',').toMutableList()
            val times = longestMenuNameLength - (menuData[1].length + menuData[2].length)
            menuData[1] = menuData[1].capitalize() + ".".repeat(times)
            goodLookingMenuList[index] = menuData.joinToString(",")
        }
    }

    println("*** Welcome to $TAVERN_NAME ***")
    goodLookingMenuList.forEach {
        val (_, menuName, price) = it.split(',')
        println("$menuName$price")
    }

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

    val patrons1 = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot")
        .toSet()
        .toList()
    val patrons2 = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").distinct()
    println(patrons1)
    println(patrons2)

    println(patronGold)
    val mutablePatronGold = patronGold.toMutableMap()
    println(mutablePatronGold)
    mutablePatronGold += "Sophie" to 6.0
    println(mutablePatronGold)

//    patronGold.getValue("Reggie")
//    patronGold.getValue("Reggie") // Exception: NoSuchElementException
    var reggieGold = patronGold.getOrElse("Reggie") { "No such patron" }
    println(reggieGold)
    reggieGold = patronGold.getOrDefault("Reggie", 0.0)
    println(reggieGold)
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName purchases $name ($type) with $price gold coin(s)."
    println(message)
    val purchaseResult = performPurchase(price.toDouble(), patronName)

    if (purchaseResult) {
        val phrase = if (name == "Dragon's Breath") {
            "$patronName admires. ${toDragonSpeak("wow. $name is really good")}"
        } else {
            "$patronName says. Thanks $name."
        }
        println(phrase)
    } else {
        println("Goodbye $patronName")
        uniquePatrons.remove(patronName)
        uniquePatronGold.remove(patronName)
    }
}

private fun performPurchase(price: Double, patronName: String): Boolean {
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
    return totalPurse > price
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
