package it.example.todo.services

import it.example.todo.entities.TodoItem

interface TodoItemService {
    fun createTodoItem(todoId: Long, todoItem: TodoItem): TodoItem

    fun updateTodoItem(id: Long, todoItem: TodoItem): TodoItem

    fun deleteTodoItem(id: Long): TodoItem
}
