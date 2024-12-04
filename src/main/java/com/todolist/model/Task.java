package com.todolist.model;

public class Task {
    private int id;
    private String description;
    private Boolean complete;

    public Task() {
    }

    public Task(int id, String description, Boolean complete) {
        this.id = id;
        this.description = description;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}

