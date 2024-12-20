package it.example.todo.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.ManyToOne
import jakarta.persistence.JoinColumn


@Entity
@Table(name = "todo_item")
class TodoItem(
    @Id
    @GeneratedValue
    val id: Long = 0,

    var content: String = "",
    var complete: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "todo_id")
    @JsonIgnore
    var todo: Todo? = null
) {
    override fun toString(): String {
        return "TodoItem(id = $id, content = $content, complete = $complete, todo = $todo)"
    }
}