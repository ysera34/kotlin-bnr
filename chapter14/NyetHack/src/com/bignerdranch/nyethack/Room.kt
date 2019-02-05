package com.bignerdranch.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Room: $name\n Danger Level: $dangerLevel"

    open fun load() = "Nobody came here..."
}

open class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "ding-dong"

    final override fun load() = "Your participation is welcomed by all residents!\n${ringBell()}"

    private fun ringBell() = "Inform your arrival at the bell tower. $bellSound"
}
