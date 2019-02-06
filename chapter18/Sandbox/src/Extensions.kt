fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun Any.easyPrint() = println(this)

fun main(args: Array<String>) {
    println("Madrigal came out of the building".addEnthusiasm())
    "Madrigal came out of the building".addEnthusiasm().easyPrint()
    42.easyPrint()
}
