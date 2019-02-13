package com.todo.todo;

public class Todo {

    private final String task;
    private final Boolean done;

    Todo(String task, Boolean done) {
        this.task = task;
        this.done = done;
    }

    private String getTask() {
        return task;
    }

    private Boolean getDone() {
        return done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "task='" + getTask() + '\'' +
                ", done=" + getDone() +
                '}';
    }
}
