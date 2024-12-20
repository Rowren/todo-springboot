package it.example.todo.services.impl

import it.example.todo.entities.Todo
import it.example.todo.exceptions.NotFoundException
import it.example.todo.repositories.TodoRepo
import it.example.todo.services.TodoService
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(val todoRepo: TodoRepo) : TodoService {
    override fun createTodo(todo: Todo): Todo {
        return todoRepo.saveAndFlush(todo)
    }

    override fun getTodo(id: Long): Todo {
        return todoRepo.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
    }

    override fun getTodoList(): List<Todo> {
        return todoRepo.findAll()
    }

    override fun updateTodo(id: Long, todo: Todo): Todo {
        val existingTodo = todoRepo.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
        existingTodo.title = todo.title
        return todoRepo.saveAndFlush(existingTodo)
    }

    override fun deleteTodo(id: Long): Todo {
        val existingTodo = todoRepo.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
        todoRepo.delete(existingTodo)
        return existingTodo
    }
}

