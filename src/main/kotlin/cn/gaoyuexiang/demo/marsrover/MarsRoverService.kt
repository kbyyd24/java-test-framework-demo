package cn.gaoyuexiang.demo.marsrover

import org.springframework.stereotype.Service

@Service
class MarsRoverService(
  private val repository: MarsRoverRepository
) {

  fun forward(id: String, length: Int) {
    repository.findById(id)
      .forward(length)
      .let { repository.save(it) }
  }
}