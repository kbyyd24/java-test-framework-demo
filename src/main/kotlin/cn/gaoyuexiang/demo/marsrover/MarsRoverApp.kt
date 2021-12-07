package cn.gaoyuexiang.demo.marsrover

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MarsRoverApp

fun main(args: Array<String>) =
  runApplication<MarsRoverApp>(*args)