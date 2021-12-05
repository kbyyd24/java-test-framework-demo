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

  listOf(
    Triple(Direction.EAST, 2, Position(3, 2)),
    Triple(Direction.WEST, 3, Position(-2, 2)),
    Triple(Direction.SOUTH, -1, Position(1, 3)),
    Triple(Direction.NORTH, 1, Position(1, 3)),
  )
    .forEach {(direction, length, movedPosition) ->
      given("a mars rover at 1,2 and direction is $direction") {
        val  marsRover = MarsRover(
          position = Position(1,2),
          direction = direction,
        )
        `when`("it move forward for $length units") {
          val movedMarsRover = marsRover.forward(length)
          then("it position changed to ${movedPosition.x},${movedPosition.y} and direction not change") {
            movedMarsRover.report().position shouldBe movedPosition
            movedMarsRover.report().direction shouldBe direction
          }
        }
      }
    }
})
