package be.sukes13

import be.sukes13.Direction.*


typealias Grid<T> = Map<Int, List<T>>

fun <T, V> Grid<T>.checkEveryPointFor(checker: (Point, Grid<T>) -> V?) =
    (0 until this.size).flatMap { y ->
        (0 until this.size).mapNotNull { x ->
            checker(Point(x, y), this)
        }
    }

fun <T> Grid<T>.get(point: Point): T = this[point.y]?.get(point.x) ?: error("Point: $point does not exist in grid")
fun <T> Grid<T>.column(at: Int) = values.map {
    it.elementAtOrNull(at)
}

fun <T> Grid<T>.row(point: Point) = this[point.y] ?: error("Row: $point.x does not exist in grid")

data class Point(val x: Int, val y: Int) {
    //@formatter:off
    val neighbours: Set<Point>
        get() = listOf(
                Point(-1, -1), Point(0, -1), Point(1, -1),
                Point(-1, 0), Point(1, 0),
                Point(-1, 1), Point(0, 1), Point(1, 1),
        ).map { vector -> this + vector }
                .toSet()

    val orthogonalNeighbours: Set<Point>
        get() = listOf(
                Point(0, -1),
                Point(-1, 0), Point(1, 0),
                Point(0, 1),
        ).map { vector -> this + vector }
                .toSet()
    //@formatter:on

    operator fun plus(vector: Point) = Point(this.x + vector.x, this.y + vector.y)

    fun touching(point: Point) = point in neighbours || point == this
}


infix fun Point.onSameRowAs(other: Point) = y == other.y
infix fun Point.onSameColumnAs(other: Point) = x == other.x
infix fun Point.moreToLeft(other: Point) = x > other.x
infix fun Point.lowerThan(other: Point) = y > other.y

fun Point.stepInDirection(direction: Direction) =
    when (direction) {
        UP -> copy(y = y + 1)
        RIGHT -> copy(x = x + 1)
        DOWN -> copy(y = y - 1)
        LEFT -> copy(x = x - 1)
    }

enum class Direction {
    UP, RIGHT, DOWN, LEFT;
}