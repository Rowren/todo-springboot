package it.example.todo.services.impl

import it.example.todo.entities.TodoItem
import it.example.todo.exceptions.NotFoundException
import it.example.todo.repositories.TodoItemRepo
import it.example.todo.repositories.TodoRepo
import it.example.todo.services.TodoItemService
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.Service

@Service
class TodoItemServiceImpl @Autowired constructor(
    val todoRepo: TodoRepo,
    val todoItemRepo: TodoItemRepo
) : TodoItemService {

    override fun createTodoItem(todoId: Long, todoItem: TodoItem): TodoItem {
        val todo = todoRepo.findById(todoId).orElseThrow {
            NotFoundException("No Todo with id $todoId")
        }
        todoItem.todo = todo
        return todoItemRepo.saveAndFlush(todoItem)
    }

    override fun updateTodoItem(id: Long, todoItem: TodoItem): TodoItem {
        val existingItem = todoItemRepo.findById(id).orElseThrow {
            NotFoundException("No TodoItem with id $id")
        }
        existingItem.content = todoItem.content
        existingItem.complete = todoItem.complete
        return todoItemRepo.saveAndFlush(existingItem)
    }

    override fun deleteTodoItem(id: Long): TodoItem {
        val existingItem = todoItemRepo.findById(id).orElseThrow {
            NotFoundException("No TodoItem with id $id")
        }
        todoItemRepo.delete(existingItem)
        return existingItem
    }
}
