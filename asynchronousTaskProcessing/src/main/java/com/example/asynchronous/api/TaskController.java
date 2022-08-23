package com.example.asynchronous.api;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {


    @Autowired
    private TaskService taskService;


    @RequestMapping(path="/", method = RequestMethod.POST)
    public void addTask(@RequestParam(value = "base") Integer base, @RequestParam(value = "exponent") Integer exponent) throws InterruptedException {
        this.taskService.addTask(base, exponent);
    }

    @GetMapping(path = "/")
    public List<Task> getTasks() {
        return this.taskService.listAllTasks();
    }

}
