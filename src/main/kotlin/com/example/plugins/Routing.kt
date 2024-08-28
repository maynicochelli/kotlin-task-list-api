package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository = TaskRepository()
    routing {
        get("/tasks") {
            call.respond(repository.tasks)
        }
        post("/tasks") {
            val task = call.receve<Task>()
            repository.save(task)
            call.respondText("Task created.", status HttpStatusCode.Created)
        }
    }
}
