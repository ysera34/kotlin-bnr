package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    WeaponPlayer().printWeaponName()
}

class Weapon(val name: String)

class WeaponPlayer {
    private var weapon: Weapon? = Weapon("Ebony Kris")

    fun printWeaponName() {
        /**
         * Smart cast to 'Weapon' is impossible,
         * because 'weapon' is a mutable property that could have been changed by this time
         */
//        if (weapon != null) {
//            println(weapon.name)
//        }
        weapon?.also {
            println(it.name)
        }
    }
}
