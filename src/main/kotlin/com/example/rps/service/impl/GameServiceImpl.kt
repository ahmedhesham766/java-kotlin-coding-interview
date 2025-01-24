package com.example.rps.service.impl

import com.example.rps.enums.Action
import com.example.rps.enums.Result
import com.example.rps.service.GameService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class GameServiceImpl : GameService {

    override fun playGame(rounds: Int): String {
        var playerAWins = 0
        var playerBWins = 0
        var draws = 0

        val player1Action = Action.ROCK
        repeat(rounds) {

            val player2Action = randomAction()
            val result = determineWinner(player1Action, player2Action)

            when (result) {
                Result.WIN -> playerAWins++
                Result.LOSE -> playerBWins++
                Result.DRAW -> draws++
            }
        }

        return """
            "Player A wins $playerAWins of $rounds games"
            "Player B wins $playerBWins of $rounds games"
            "Draws: $draws of $rounds games"
        """.trimIndent().lines().joinToString("\n")
    }

    private fun randomAction(): Action {
        return Action.values()[Random.nextInt(Action.values().size)]
    }

    private fun determineWinner(playerA: Action, playerB: Action): Result {
        return when {
            playerA == playerB -> Result.DRAW
            playerA == Action.ROCK && playerB == Action.SCISSOR -> Result.WIN
            playerA == Action.PAPER && playerB == Action.ROCK -> Result.WIN
            playerA == Action.SCISSOR && playerB == Action.PAPER -> Result.WIN
            else -> Result.LOSE
        }
    }

}