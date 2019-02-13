package com.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = {"/todo"}, method = RequestMethod.GET)
    public ResponseEntity<String> getAllTodo() throws IOException {
        String allTodo = todoService.getAllTodo();
        return ResponseEntity.ok(allTodo);
    }

    @RequestMapping(value = {"/todo"}, method = RequestMethod.POST)
    public ResponseEntity<String> saveTodo(@RequestBody Todo todo) throws IOException {
        todoService.saveTodo(todo);
        return ResponseEntity.created(URI.create("/todo")).build();
    }
}
