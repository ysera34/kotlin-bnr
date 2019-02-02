import java.lang.IllegalStateException

fun main(args: Array<String>) {
    var jugglingSwords: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        jugglingSwords = 2
    }

    try {
        checkProficient(jugglingSwords)
        jugglingSwords = jugglingSwords!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("juggle with $jugglingSwords knives.")
}

fun checkProficient(jugglingSwords: Int?) {
//    jugglingSwords ?: throw IllegalStateException("The player can not juggle.")
//    jugglingSwords ?: throw UnskilledSwordJugglerException()
    checkNotNull(jugglingSwords) { "The player can not juggle." }
}

class UnskilledSwordJugglerException() : IllegalStateException("The player can not juggle.")
