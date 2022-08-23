package com.example.asynchronous.api;

import com.example.asynchronous.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/tasks")
public class TaskHtmlController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTasksHtml(Model model){
        model.addAttribute("tasks", this.taskService.listAllTasks());
        return "tasks";
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addTaskHtml(@RequestParam(value = "base") Integer base, @RequestParam(value = "exponent") Integer exponent) throws InterruptedException {
        this.taskService.addTask(base, exponent);
    }

}