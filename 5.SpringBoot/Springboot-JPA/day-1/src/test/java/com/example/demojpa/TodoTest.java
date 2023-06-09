package com.example.demojpa;

import com.example.demojpa.entity.Todo;
import com.example.demojpa.repository.TodoRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest

public class TodoTest {

    @Autowired
    private Faker faker;
    
    @Autowired
    private TodoRepository todoRepository;

    @Test
    void save_todo() {
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            Todo todo = new Todo();
            todo.setTitle(faker.name().firstName());
            todo.setStatus(rd.nextInt(2)==1);

            todoRepository.save(todo);
        }
    }

    @Test
    void update_todo() {
        todoRepository.updateTodo(1,"abc update", true);
    }

    @Test
    void delete_todo() {
        todoRepository.deleteTodo(1);
    }
}
