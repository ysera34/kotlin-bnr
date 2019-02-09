import kotlin.system.measureNanoTime

fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0) return false
    }
    return true
}

fun main(args: Array<String>) {
    val listInNanos = measureNanoTime {
        val toList = (1..7917).toList().filter { it.isPrime() }.take(1000)
        println(toList)
    }
    println("listInNanos: $listInNanos")

    val sequenceInNanos = measureNanoTime {
        val oneThousandPrimes = generateSequence(3) { value ->
            value + 1
        }.filter { it.isPrime() }.take(1000).toList()
        println(oneThousandPrimes)
    }
    println("sequenceInNanos $sequenceInNanos")
}
