package cn.gaoyuexiang.demo.marsrover

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class MarsRoverKotestTest : BehaviorSpec({
  given("a mars rover") {
    val marsRover = MarsRover(
      position = Position(1, 2),
      direction = Direction.EAST,
    )
    `when`("it report information") {
      val (position, direction) = marsRover.report()
      then("get it's position and direction") {
        position shouldBe Position(1, 2)
        direction shouldBe Direction.EAST
      }
    }
  }
})
