package cn.gaoyuexiang.demo.marsrover

import cn.gaoyuexiang.demo.marsrover.fixture.MarsRoverFixture
import spock.lang.Specification

class MarsRoverSpockTest extends Specification {

  def "should return mars rover position and direction when mars rover report"() {
    given:
    def marsRover = MarsRoverFixture.buildMarsRover(
      position: new Position(1, 2),
      direction: Direction.EAST,
    )

    when:
    def marsRoverInfo = marsRover.report()

    then:
    marsRoverInfo.position == new Position(1, 2)
    marsRoverInfo.direction == Direction.EAST
  }

}
