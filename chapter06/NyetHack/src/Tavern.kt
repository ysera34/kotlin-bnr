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

    var beverage3 = readLine()
    beverage3 = null

    if (beverage3 != null) {
        beverage3 = beverage3.capitalize() // Smart cast to kotlin.String
    } else {
        println("beverage is null")
    }

    println(beverage3)

    val beverageServed: String = beverage3 ?: "Beer"
    println(beverageServed)

    var beverage4 = readLine()
    beverage4?.let {
        beverage4 = it.capitalize()
    } ?: println("beverage is null")
}
