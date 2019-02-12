package com.todo.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class Todo {

    @RequestMapping("todo")
    public String getAllTodo() throws IOException {

        String pwd = System.getProperty("user.dir");
        String fileName = String.format("%s/src/main/resources/todo.json", pwd);
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
