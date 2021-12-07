package cn.gaoyuexiang.demo.marsrover

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.slot
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MarsRoverServiceKotestTest(
  service: MarsRoverService,
) : FunSpec() {
  @MockkBean lateinit var repository: MarsRoverRepository
  override fun extensions() = listOf(SpringExtension)

  init {
    test("should move mars rover success") {
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
      movedMarsRover.report().position shouldBe Position(1, 5)
      movedMarsRover.report().direction shouldBe Direction.NORTH
    }
  }
}
