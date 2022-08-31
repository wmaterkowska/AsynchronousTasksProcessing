package com.example.asynchronous.api;

import com.example.asynchronous.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;


@Controller
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskHtmlController {

    @Autowired
    private TaskService taskService;


    @RequestMapping(method = RequestMethod.GET)
    public String getTasks(Model model){
        model.addAttribute("tasks", this.taskService.getAllTasks());
        return "tasks";
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addTask(@RequestParam(value = "base") Integer base, @RequestParam(value = "exponent") Integer exponent) throws InterruptedException, ExecutionException {
        this.taskService.addTask(base, exponent);
    }

}
