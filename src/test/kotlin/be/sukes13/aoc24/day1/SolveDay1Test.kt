package be.sukes13.aoc24.day1

import be.sukes13.readFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolveDay1Test {

    @Test
    fun `example input part 1`() {
        val input = readFile("aoc24/day1/exampleInput.txt")
        assertThat(part1(input)).isEqualTo(11)
    }

    @Test
    fun `actual input part 1`() {
        val input = readFile("aoc24/day1/input.txt")
        assertThat(part1(input)).isEqualTo(2742123)
    }

    @Test
    fun `example input part 2`() {
        val input = readFile("aoc24/day1/exampleInput.txt")
        assertThat(part2(input)).isEqualTo(31)
    }


    @Test
    fun `actual input part 2`() {
        val input = readFile("aoc24/day1/input.txt")
        assertThat(part2(input)).isEqualTo(21328497)
    }
}