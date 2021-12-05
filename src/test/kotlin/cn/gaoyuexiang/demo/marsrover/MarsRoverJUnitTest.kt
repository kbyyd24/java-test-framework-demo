package cn.gaoyuexiang.demo.marsrover

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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
    assertThat(marsRoverInfo.position).isEqualTo(Position(1, 2))
    assertThat(marsRoverInfo.direction).isEqualTo(Direction.EAST)
  }

  @ParameterizedTest(name = "should move mars rover from position 1,2 forward to {2} when direction is {0} and move length is {1}")
  @MethodSource("marsRoverForwardSource")
  fun `should move mars rover from position forward success`(direction: Direction, length: Int, movedPosition: Position) {
    // given
    val marsRover = MarsRover(
      position = Position(1, 2),
      direction = direction,
    )

    // when
    val movedMarsRover = marsRover.forward(length)

    // then
    assertThat(movedMarsRover.report().position).isEqualTo(movedPosition)
    assertThat(movedMarsRover.report().direction).isEqualTo(direction)
  }

  companion object {
    @JvmStatic
    fun marsRoverForwardSource(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(
          Direction.EAST,
          2,
          Position(3, 2),
        ),
        Arguments.of(
          Direction.WEST,
          3,
          Position(-2, 2),
        ),
        Arguments.of(
          Direction.SOUTH,
          -1,
          Position(1, 3),
        ),
        Arguments.of(
          Direction.NORTH,
          1,
          Position(1, 3),
        ),
      )
    }
  }
}