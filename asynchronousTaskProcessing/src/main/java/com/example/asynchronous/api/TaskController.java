package com.example.asynchronous.api;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.service.TaskService;
import org.hibernate.loader.entity.NaturalIdEntityJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {


    @Autowired
    private TaskService taskService;

    @Async
    @RequestMapping(path="/", method = RequestMethod.POST)
    public void addTask(@RequestParam(value = "base") Integer base, @RequestParam(value = "exponent") Integer exponent) throws InterruptedException {
        final Task newTask = new Task(base,exponent);
        this.taskService.addTask(newTask);
        newTask.calculateResult();
    }

    @GetMapping(path = "/tasks")
    public List<Task> getTasks() {
        return this.taskService.listAllTasks();}

}
