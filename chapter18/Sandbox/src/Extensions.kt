val String.numVowels
    get() = count { "aeiouy".contains(it) }

/**
 * Extension property cannot be initialized because it has no backing field
 */
//var String.preferredCharacters = 10

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

//fun Any.easyPrint() = println(this)
//fun Any.easyPrint(): Any {
fun <T> T.easyPrint(): T {
    println(this)
    return this
}

infix fun String?.printWithDefault(default: String) = print(this ?: default)

fun main(args: Array<String>) {
    println("Madrigal came out of the building".addEnthusiasm())
    "Madrigal came out of the building".addEnthusiasm().easyPrint()
    "Madrigal came out of the building".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()

    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "default string"
}
