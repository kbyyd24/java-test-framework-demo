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


  def "should move mars rover from position 1,2 forward to #movedPosition.x,#movedPosition.y when direction is #direction and move length is #length"() {
    given:
    def marsRover = MarsRoverFixture.buildMarsRover(
      position: new Position(1, 2),
      direction: direction,
    )

    when:
    def movedMarsRover = marsRover.forward(length)

    then:
    movedMarsRover.position == movedPosition
    movedMarsRover.direction == direction

    where:
    direction       | length || movedPosition
    Direction.EAST  | 2      || new Position(3, 2)
    Direction.WEST  | 3      || new Position(-2, 2)
    Direction.SOUTH | -1     || new Position(1, 3)
    Direction.NORTH | 1      || new Position(1, 3)
  }

}
