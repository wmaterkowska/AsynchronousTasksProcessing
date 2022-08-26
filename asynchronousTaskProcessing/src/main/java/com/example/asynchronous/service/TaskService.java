package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableAsync
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {

        /*
        Iterable<Task> tasks = this.taskRepository.findAll();
        List<Task> taskList = new ArrayList<>();
        tasks.forEach(task ->{taskList.add(task);});
        return taskList;
        */
        return this.taskRepository.findAll();
    }

    @Async
    public void addTask(int base, int exponent) throws InterruptedException {
        final Task newTask = Task.builder().base(base).exponent(exponent).build();
        this.taskRepository.save(newTask);
        newTask.calculateResult(this.taskRepository);
    }
}
