package cn.gaoyuexiang.demo.marsrover

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarsRoverJUnitTest {
  @Test
  fun `should return mars rover position and direction when mars rover report`() {
    // given
    val marsRover = MarsRover(
      position = Position(1, 2),
      direction = Direction.EAST,
    )

    // when
    val marsRoverInfo = marsRover.report()

    // then
    assertThat(marsRoverInfo.position).isEqualTo(Position(1,2))
    assertThat(marsRoverInfo.direction).isEqualTo(Direction.EAST)
  }
}