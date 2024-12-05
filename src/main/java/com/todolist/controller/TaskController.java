package com.todolist.controller;

import com.todolist.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/register-tasks")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "register-tasks";
    }

    @PostMapping("/register-tasks")
    public String registerTask(@ModelAttribute Task task, Model model) {
        task.setComplete(false);
        tasks.add(task);
        return "redirect:/tasks";
    }
}
