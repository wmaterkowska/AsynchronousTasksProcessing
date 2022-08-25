package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableAsync
public class TaskService {

    private final TaskRepository taskRepository;

    private final List<Task> tasks;

    public TaskService(TaskRepository taskRepository, List<Task> tasks) {
        this.taskRepository = taskRepository;
        this.tasks = tasks;
    }

    public List<Task> listAllTasks() {
        return this.taskRepository.findAll();
    }

    public List<Task> getAllTasks() {

        for (Task task : this.tasks) {
            updateTask(task.getId(), task.getStatus(), task.getResult());
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
        this.tasks.add(newTask);

        newTask.calculateResult();
    }

    public void updateTask(long id, float status, long result) {
        taskRepository.updateTask(id, status, result);
    }

}
