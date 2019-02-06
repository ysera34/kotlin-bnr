package com.bignerdranch.nyethack

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0

    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}

enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    fun getDirectionName(direction: Direction) =
        when (direction) {
            NORTH -> "North"
            EAST -> "East"
            SOUTH -> "South"
            WEST -> "West"
        }

    fun updateCoordinate(playerCoordinate: Coordinate) =
//        Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)
        playerCoordinate + coordinate
}
