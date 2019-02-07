fun main(args: Array<String>) {
    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    println(employeeShirtSizes)
    println(employeeShirtSizes["Denny"])

    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accumulated value: $accumulator")
        println("number: $number")
        accumulator + (number * 3)
    }
    println(foldedValue)
}
