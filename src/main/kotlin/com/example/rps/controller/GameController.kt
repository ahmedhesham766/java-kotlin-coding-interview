package com.example.rps.controller

import com.example.rps.service.GameService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(private val gameService: GameService) {

    @GetMapping("/play")
    fun playGame(): String {
        return gameService.playGame(100)
    }
}