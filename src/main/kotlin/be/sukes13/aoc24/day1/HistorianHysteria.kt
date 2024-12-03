package be.sukes13.aoc24.day1

import be.sukes13.mapLines
import kotlin.math.abs

fun part1(input: String) = input.toVerticalLists()
    .run { first.sorted() to second.sorted() }
    .run {
        first.mapIndexed { index, leftValue ->
            abs(leftValue - second[index])
        }.sum()
    }

fun part2(input: String) = input.toVerticalLists()
    .run {
        first.sumOf { leftValue ->
            leftValue * second.count { it == leftValue }
        }
    }


private fun String.toVerticalLists() = mapLines {
    it.split("   ").run {
        first().toInt() to last().toInt()
    }
}.unzip()


