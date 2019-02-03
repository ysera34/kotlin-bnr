import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
//val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")
val patronList = mutableListOf("Eli", "Mordoc", "Sophie") // MutableList<String>
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val goodLookingMenuList = menuList.toMutableList()

fun main(args: Array<String>) {

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

    println(patronList)
    patronList.remove("Eli")
    patronList.add("Alex")
    patronList.add(0, "Alex")
    patronList[0] = "Alexis"
    println(patronList)

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

//    goodLookingMenuList.also { menu ->
//        var longestMenuNameLength = 0
//        menu.forEach {
//            val menuData = it.split(',')
//            if (longestMenuNameLength < menuData[1].length + menuData[2].length) {
//                longestMenuNameLength = menuData[1].length + menuData[2].length
//            }
//        }
//        longestMenuNameLength += 12
//        menu.forEachIndexed { index, menuLine ->
//            val menuData = menuLine.split(',').toMutableList()
//            val times = longestMenuNameLength - (menuData[1].length + menuData[2].length)
//            menuData[1] = menuData[1].capitalize() + ".".repeat(times)
//            goodLookingMenuList[index] = menuData.joinToString(",")
//        }
//    }


    println("*** Welcome to $TAVERN_NAME ***")
    goodLookingMenuList.forEach {
        val (_, menuName, price) = it.split(',')
        println("$menuName$price")
    }

    patronList.forEachIndexed { index, patron ->
        println("Good Night, $patron. You are ${index + 1}th patron.")
        placeOrder(patron, menuList.shuffled().first())
    }
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    val patrons1 = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot")
        .toSet()
        .toList()
    val patrons2 = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").distinct()
    println(patrons1)
    println(patrons2)
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName purchases $name ($type) with $price gold coin(s)."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "$patronName admires. ${toDragonSpeak("wow. $name is really good")}"
    } else {
        "$patronName says. Thanks $name."
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
