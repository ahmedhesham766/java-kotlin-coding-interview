package com.example.rps.service

interface GameService {
    fun playGame(rounds: Int): String
}