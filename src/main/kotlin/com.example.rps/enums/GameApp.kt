package com.example.rps.enums

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GameApp

fun main(args: Array<String>) {
	runApplication<GameApp>(*args)
}
