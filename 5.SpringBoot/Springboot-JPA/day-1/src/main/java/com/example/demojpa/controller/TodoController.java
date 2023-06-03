package com.example.demojpa.controller;

import com.example.demojpa.entity.Todo;
import com.example.demojpa.repository.TodoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TodoController {

    TodoRepository todoRepository;

    @GetMapping("/")
    public String getIndex(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/api/v1/todos")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        Todo newTodo = new Todo(null, todo.getTitle(), false);
        todoRepository.save(newTodo);
        return null;   // 201
    }

    @PutMapping("/api/v1/todos")
    public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        // Kiểm tra id
        Todo updatedTodo = todoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not Found");
                });

        // Cập nhật
        updatedTodo.setTitle(todo.getTitle());
        updatedTodo.setStatus(todo.getStatus());
        todoRepository.save(updatedTodo);
        return ResponseEntity.ok(updatedTodo);   // 200
    }

    @DeleteMapping("/api/v1/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id) {
        // Kiểm tra id
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not Found");
                });
        todoRepository.delete(todo);
        return ResponseEntity.noContent().build();  //204
    }
}
