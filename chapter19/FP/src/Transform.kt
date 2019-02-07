fun main(args: Array<String>) {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal" }
        .map { baby -> "$baby, with the cutest little tail ever!" }
    println(animals)
    println(babies)

    val tenDollarWords = listOf("auspicious", "avuncular", "obviate")
    val tenDollarWordLengths = tenDollarWords.map { it.length }
    println(tenDollarWords)
    println(tenDollarWords.size)
    println(tenDollarWordLengths)
    println(tenDollarWordLengths.size)

    val numbers = listOf(listOf(1, 2, 3), listOf(3, 4, 5, 6)).flatMap { it } // flatten()
    println(numbers)
}
