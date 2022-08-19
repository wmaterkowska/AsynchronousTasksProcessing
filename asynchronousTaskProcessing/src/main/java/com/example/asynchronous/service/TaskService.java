package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskRepository;

import javax.annotation.PostConstruct;
import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;

    @PostConstruct
    void test(){
        taskRepository.save(new Task());

    }

    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }


}
