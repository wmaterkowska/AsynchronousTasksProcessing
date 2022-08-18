package com.example.asynchronousTaskProcessing.model;

import com.example.asynchronousTaskProcessing.data.Task;
import com.example.asynchronousTaskProcessing.data.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;


    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }


}
