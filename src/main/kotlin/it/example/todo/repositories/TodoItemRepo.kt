package it.example.todo.repositories

import it.example.todo.entities.TodoItem
import org.springframework.data.jpa.repository.JpaRepository

interface TodoItemRepo:JpaRepository<TodoItem,Long>