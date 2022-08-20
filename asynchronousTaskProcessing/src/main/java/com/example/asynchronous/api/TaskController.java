package com.example.asynchronous.api;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public void addTask(@RequestBody Task task){
        this.taskService.addTask(task);
    }

//    @GetMapping
//    public List<Task> getTasks(){
//        return this.taskService.listAllTasks();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String getTasks(Model model){
        model.addAttribute("tasks", this.taskService.listAllTasks());
        return "listOfTasks";
    }

}
