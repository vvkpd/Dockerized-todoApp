package com.todo.todo;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

@Service
class TodoService {

    private final String pwd = System.getProperty("user.dir");
    private final String fileName = String.format("%s/src/main/resources/todo.json", pwd);

    String getAllTodo() throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    void saveTodo(Todo todo) throws IOException {
        JSONArray todos = new JSONArray(getAllTodo());
        todos.put(todo);
        Files.write(Paths.get(fileName), Collections.singleton(todos.toString()));
    }
}
