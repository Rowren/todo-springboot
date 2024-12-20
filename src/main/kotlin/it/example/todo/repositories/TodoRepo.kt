package it.example.todo.repositories

import it.example.todo.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepo:JpaRepository<Todo, Long>