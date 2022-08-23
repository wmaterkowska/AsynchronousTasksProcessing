package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableAsync
public class TaskService {

    private List<Task> taskList;

    private static volatile int counter;


    public TaskService(List<Task> taskList) {this.taskList = taskList;}

    public List<Task> listAllTasks() {
        return this.taskList;
    }

    @Async
    public void addTask(int base, int exponent) throws InterruptedException {
        final Task newTask = Task.builder().id(++counter).base(base).exponent(exponent).build();
        this.taskList.add(newTask);

        newTask.calculateResult();
    }


}
