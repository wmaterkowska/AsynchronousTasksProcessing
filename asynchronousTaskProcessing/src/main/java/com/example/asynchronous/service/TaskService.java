package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {


    private List<Task> taskList;

    public TaskService(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> listAllTasks(){
        return this.taskList;
    }

    public void addTask(Task task){
        this.taskList.add(task);
    }

    public List<Integer> statusesList(List<Task> taskList) {
        List<Integer> statusList = new ArrayList<>();
        for (Task task: this.taskList) {
            statusList.add(task.getStatus());
        }
        return statusList;
    }

    public List<Long> resultsList(List<Task> taskList) {
        List<Long> resultList = new ArrayList<>();
        for (Task task: this.taskList) {
            resultList.add(task.getResult());
        }
        return resultList;
    }


}
