package com.example.Todo_list.services;

import com.example.Todo_list.models.Todo;
import com.example.Todo_list.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(String task) {
        Todo todo = new Todo(task);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public void toggleDone(Long id) {
        todoRepository.findById(id).ifPresent(todo -> {
            todo.setDone(!todo.isDone());
            todoRepository.save(todo);
        });
    }
}
