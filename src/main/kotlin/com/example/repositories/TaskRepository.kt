
class TaskRepository {

  val tasks get() = _tasks.toList()

  fun save(task: Task) {
    _tasks.add(task)
  }

  companion object {
    private val _tasks = MutableListOf<Task>()
  }

}
