package com.todolist.controller;

import com.todolist.model.Task;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping()
    public List<Task> getAllTasks() {
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id){
        for (Task task: tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @PostMapping()
    public Task createTask(@RequestBody Task task) {
        int id = tasks.size() + 1;
        task.setId(id);
        tasks.add(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(updatedTask.getDescription());
                task.setComplete(updatedTask.getComplete());
                return task;
            }
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable int id) {
        for (Task task : tasks) {
           if (task.getId() == id) {
               tasks.remove(task);
               return true;
           }
        }
        return false;
    }
}
