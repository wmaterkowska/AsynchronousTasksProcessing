package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import org.h2.util.IntArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.persistence.Basic;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@Service
@EnableAsync
public class TaskService {

    private List<Task> taskList;


    public TaskService(List<Task> taskList) {this.taskList = taskList;}

    public List<Task> listAllTasks() {
        return this.taskList;
    }

    public void addTask(Task task){this.taskList.add(task);}


}
