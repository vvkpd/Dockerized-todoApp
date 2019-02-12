package com.todo.todo;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
class TodoService {

    private final String pwd = System.getProperty("user.dir");
    private final String fileName = String.format("%s/src/main/resources/todo.json", pwd);

    String getAllTodo() throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
