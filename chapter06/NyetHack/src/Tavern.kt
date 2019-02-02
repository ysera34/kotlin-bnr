fun main(args: Array<String>) {
    var signatureDrink = "beer"
//    signatureDrink = null // Error: Null can not be a value of a non-null type String

    var beverage = readLine()
//    beverage = null
//    beverage?.capitalize()
    beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Beer"
        }
    }
    println(beverage)
}
