package cn.gaoyuexiang.demo.marsrover

data class MarsRover(
  private val position: Position,
  private val direction: Direction,
) {
  fun report(): MarsRoverInfo {
    return MarsRoverInfo(position = position, direction = direction)
  }

  fun forward(length: Int): MarsRover {
    return when (direction) {
      Direction.EAST -> this.copy(position = position.copy(x = position.x + length))
      Direction.WEST -> this.copy(position = position.copy(x = position.x - length))
      Direction.SOUTH -> this.copy(position = position.copy(y = position.y - length))
      Direction.NORTH -> this.copy(position = position.copy(y = position.y + length))
    }
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