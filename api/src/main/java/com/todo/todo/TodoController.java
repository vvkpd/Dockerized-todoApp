package com.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/todo")
    @GetMapping
    public ResponseEntity<String> getAllTodo() throws IOException {
        String allTodo = todoService.getAllTodo();
        return ResponseEntity.ok(allTodo);
    }
}
