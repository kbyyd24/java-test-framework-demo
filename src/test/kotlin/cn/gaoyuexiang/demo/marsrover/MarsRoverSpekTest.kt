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
})