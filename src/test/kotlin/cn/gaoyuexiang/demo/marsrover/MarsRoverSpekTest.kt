package cn.gaoyuexiang.demo.marsrover

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object MarsRoverSpekTest : Spek({
  describe("should report mars rover information") {
    it("should return mars rover position and direction when mars rover report") {
      // given
      val marsRover = MarsRover(
        position = Position(1, 2),
        direction = Direction.EAST,
      )
      // when
      val (position, direction) = marsRover.report()

      // then
      assertThat(position).isEqualTo(Position(1, 2))
      assertThat(direction).isEqualTo(Direction.EAST)
    }
  }

  describe("should move mars rover forward") {
    listOf(
      Triple(Direction.EAST, 2, Position(3, 2)),
      Triple(Direction.WEST, 3, Position(-2, 2)),
      Triple(Direction.SOUTH, -1, Position(1, 3)),
      Triple(Direction.NORTH, 1, Position(1, 3)),
    )
      .forEach { (direction, length, movedPosition) ->
        it("should move mars rover from 1,2 to ${movedPosition.x},${movedPosition.y} when direction is $direction and move length is $length") {
          // given
          val marsRover = MarsRover(
            position = Position(1,2),
            direction = direction,
          )

          // when
          val movedMarsRover = marsRover.forward(length)

          // then
          assertThat(movedMarsRover.report().position).isEqualTo(movedPosition)
          assertThat(movedMarsRover.report().direction).isEqualTo(direction)
        }
      }
  }
})