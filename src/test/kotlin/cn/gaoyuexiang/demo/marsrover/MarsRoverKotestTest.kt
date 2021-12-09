package cn.gaoyuexiang.demo.marsrover

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class MarsRoverKotestTest : FunSpec({
  test("should return mars rover position and direction when mars rover report") {
    val marsRover = MarsRover(
      position = Position(1, 2),
      direction = Direction.EAST,
    )
    val (position, direction) = marsRover.report()
    position shouldBe Position(1, 2)
    direction shouldBe Direction.EAST
  }

  context("data test") {
    withData(
      nameFn = { (direction, length, position) ->
        "should move mars rover from 1,2 to ${position.x},${position.y} when direction is $direction and move length is $length"
      },
      Triple(Direction.EAST, 2, Position(3, 2)),
      Triple(Direction.WEST, 3, Position(-2, 2)),
      Triple(Direction.SOUTH, -1, Position(1, 3)),
      Triple(Direction.NORTH, 1, Position(1, 3)),
    ) { (direction, length, movedPosition) ->
      val marsRover = MarsRover(
        position = Position(1, 2),
        direction = direction,
      )
      val movedMarsRover = marsRover.forward(length)
      movedMarsRover.report().position shouldBe movedPosition
      movedMarsRover.report().direction shouldBe direction
    }
  }
})
