package com.example.Todo_list.controllers;

import com.example.Todo_list.models.Todo;
import com.example.Todo_list.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        long completedCount = todos.stream().filter(Todo::isDone).count();

        model.addAttribute("todos", todos);
        model.addAttribute("completedCount", completedCount);

        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task) {
        todoService.addTodo(task);
        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable Long id) {
        todoService.toggleDone(id);
        return "redirect:/";
    }
}