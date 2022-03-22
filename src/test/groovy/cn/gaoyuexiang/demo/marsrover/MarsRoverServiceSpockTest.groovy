package cn.gaoyuexiang.demo.marsrover

import cn.gaoyuexiang.demo.marsrover.fixture.MarsRoverFixture
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class MarsRoverServiceSpockTest extends Specification {
  @SpringBean
  MarsRoverRepository repository = Mock()

  @Autowired
  MarsRoverService service
    // = new MarsRoverService(repository)

  def "should move mars rover forward success"() {
    given:
    def id = "id"
    def marsRover = MarsRoverFixture.buildMarsRover(
      position: new Position(1, 2),
      direction: Direction.NORTH,
    )
    repository.findById(id) >> marsRover

    when:
    service.forward(id, 3)

    then:
    1 * repository.save({ it.position == new Position(1, 5) })
  }
}
