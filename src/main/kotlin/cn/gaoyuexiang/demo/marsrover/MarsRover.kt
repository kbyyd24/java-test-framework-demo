package cn.gaoyuexiang.demo.marsrover

class MarsRover(
  private val position: Position,
  private val direction: Direction,
) {
  fun report(): MarsRoverInfo{
    return MarsRoverInfo(position = position, direction = direction)
  }
}

data class MarsRoverInfo(
  val position: Position,
  val direction: Direction,
)

data class Position(
  val x: Int,
  val y: Int,
)

enum class Direction {
  EAST, WEST, SOUTH, NORTH
}