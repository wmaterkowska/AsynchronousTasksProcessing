package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskRepository;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskService {

    private TaskRepository taskRepository;
    private Task task;

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


    @Async
    public void statusOfTask()
            throws InterruptedException, ExecutionException {
        System.out.println("Processing the task "
                + Thread.currentThread().getName());
        Future<String> future = task.resultOfTask();

        while (true) {
            if (future.isDone()) {
                System.out.println("Result from asynchronous process - " + future.get());
                break;
            }
            System.out.println("Continue doing something else. ");
            Thread.sleep(1000);
        }
    }


}
