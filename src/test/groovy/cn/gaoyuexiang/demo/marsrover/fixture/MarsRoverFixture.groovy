package cn.gaoyuexiang.demo.marsrover.fixture

import cn.gaoyuexiang.demo.marsrover.MarsRover
import groovy.transform.NamedVariant

class MarsRoverFixture {

  @NamedVariant
  static MarsRover buildMarsRover(position, direction) {
    new MarsRover(position, direction)
  }

}
