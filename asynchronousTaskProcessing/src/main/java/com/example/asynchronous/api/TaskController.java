package com.example.asynchronous.api;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public void addTask(@RequestBody Task task){
        this.taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return this.taskService.listAllTasks();
    }

}
