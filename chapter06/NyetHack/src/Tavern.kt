fun main(args: Array<String>) {
    var signatureDrink = "beer"
//    signatureDrink = null // Error: Null can not be a value of a non-null type String

    var beverage1 = readLine()
//    beverage = null
//    beverage?.capitalize()
    beverage1 = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Beer"
        }
    }
    println(beverage1)

//    var beverage2 = readLine()
//    beverage2 = null
//    beverage2!!.capitalize() // Runtime Error: Exception in thread "main" kotlin.KotlinNullPointerException
    var beverage2 = readLine()!!.capitalize()
}
