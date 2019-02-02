fun main(args: Array<String>) {
    var jugglingSwords: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        jugglingSwords = 2
    }

    checkProficient(jugglingSwords)
    jugglingSwords = jugglingSwords!!.plus(1)

    println("juggle with $jugglingSwords knives.")
}

fun checkProficient(jugglingSwords: Int?) {
    jugglingSwords ?: throw IllegalArgumentException("The player can not juggle.")
}
