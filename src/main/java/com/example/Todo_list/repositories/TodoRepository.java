package com.example.Todo_list.repositories;

import com.example.Todo_list.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
