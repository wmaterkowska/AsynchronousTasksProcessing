package com.example.asynchronous.api;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {


    @Autowired
    private TaskService taskService;

    @RequestMapping(path="/", method = RequestMethod.POST)
    public String addTask(@RequestParam(value = "base") Integer base, @RequestParam(value = "exponent") Integer exponent){
        final Task newTask = new Task(base,exponent);
        this.taskService.addTask(newTask);
        return "task added";
    }

//    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void addTaskByBody(@RequestBody Task task){
//        this.taskService.addTask(task);
//    }

//    @RequestMapping(path="/tasks", method = RequestMethod.GET)
//    public String getTasks(Model model){
//    model.addAttribute("tasks", this.taskService.listAllTasks());
//        return "tasks";
//    }

    @GetMapping(path = "/tasks")
    public List<Task> getTasks(){return this.taskService.listAllTasks();}

}
