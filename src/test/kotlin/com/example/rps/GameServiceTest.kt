package com.example.rps

import kotlin.test.Test
import kotlin.test.assertTrue

class GameServiceTest {

    private val gameService = GameService()

    @Test
    fun `test playGame output format`() {
        val rounds = 100
        val output = gameService.playGame(rounds)
        val lines = output.lines()

        println("Test Output: $output")

        assertTrue(lines.size == 3, "Output should have exactly 3 lines")

        assertTrue(lines[0].matches(Regex("\"Player A wins \\d+ of $rounds games\"")), "Line 1 format is incorrect")
        assertTrue(lines[1].matches(Regex("\"Player B wins \\d+ of $rounds games\"")), "Line 2 format is incorrect")
        assertTrue(lines[2].matches(Regex("\"Draws: \\d+ of $rounds games\"")), "Line 3 format is incorrect")
    }
}