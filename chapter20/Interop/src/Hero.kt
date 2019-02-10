@file:JvmName("Hero")

fun main(args: Array<String>) {
    val adversary = Jhava()
    println(adversary.utterGreeting())

    val friendshipLevel = adversary.determineFriendshipLevel()
    println(friendshipLevel?.toLowerCase() ?: "I do not know what it means.")

    val adversaryHitPoints: Int = adversary.hitPoints
    println(adversaryHitPoints.dec())
    println(adversaryHitPoints.javaClass)

    adversary.greeting = "Hi. A mighty man."
    println(adversary.utterGreeting())

    adversary.offerFood()
}

fun makeProclamation() = "Hi. A monster."

@JvmOverloads
fun handOverFood(leftHand: String = "strawberry", rightHand: String = "meat") {
    println("gave me delicious $leftHand and $rightHand")
}

class Spellbook {
    @JvmField
    val spells = listOf("Magic Ms. L", "Lay on Hans")

    companion object {
        @JvmField
        val MAX_SPELL_COUNT = 10

        @JvmStatic
        fun getSpellbookGreeting() = println("I am the great grimoire!")
    }
}
