fun main(args: Array<String>) {
    val itemsOfManyColors = listOf(
        listOf("red apple", "green apple", "blue apple"),
        listOf("red fish", "blue fish"), listOf("yellow banana", "teal banana")
    )

    val redItems = itemsOfManyColors.flatMap { it.filter { it.contains("red") } }
    println(redItems)

    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number).map { number % it }
            .none { it == 0 } // .all { it != 0 }
    }
    println(primes)
}
