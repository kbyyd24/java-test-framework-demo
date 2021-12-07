package cn.gaoyuexiang.demo.marsrover

import com.ninjasquad.springmockk.MockkBean
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.slot
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MarsRoverServiceJUnitTest(
  @Autowired
  val service: MarsRoverService

) {

  @MockkBean
  private lateinit var repository: MarsRoverRepository


  @Test
  fun `should move mars rover forward success`() {
    // given
    val id = "id"
    val marsRover = MarsRover(
      position = Position(1, 2),
      direction = Direction.NORTH,
    )
    every { repository.findById(id) } returns marsRover
    val marsRoverSlot = slot<MarsRover>()
    every { repository.save(capture(marsRoverSlot)) } just Runs

    // when
    service.forward(id, 3)

    // then
    val movedMarsRover = marsRoverSlot.captured
    assertThat(movedMarsRover.report().position).isEqualTo(Position(1, 5))
    assertThat(movedMarsRover.report().direction).isEqualTo(Direction.NORTH)
  }
}