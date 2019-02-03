class Player {
    var name = "mardregal"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    fun castFireball(numFireballs: Int = 2) = // default argument
        println("A bunch of fireballs appear. (x$numFireballs)")
}
