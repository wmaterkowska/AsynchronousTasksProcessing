package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableAsync
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listAllTasks() {
        return this.taskRepository.findAll();
    }

    public List<Task> getAllTasks() {

        //updateTasks();
        for (Task task : taskRepository.findAll()) {
            updateStatus(task.getId(), task.getStatus());
        }

        Iterable<Task> tasks = this.taskRepository.findAll();
        List<Task> taskList = new ArrayList<>();
        tasks.forEach(task ->{taskList.add(task);});

        return taskList;
    }

    @Async
    public void addTask(int base, int exponent) throws InterruptedException {
        final Task newTask = Task.builder().base(base).exponent(exponent).build();
        this.taskRepository.save(newTask);

        newTask.calculateResult();
    }


    private void updateTasks(){
        for (Task task: taskRepository.findAll()) {
            float currentStatus = task.getStatus();
            task.setStatus(currentStatus);
            task.setResult(2);
        }
    }

    public void updateStatus(long id, float status) {
        taskRepository.updateStatus(id, status);
    }

}
