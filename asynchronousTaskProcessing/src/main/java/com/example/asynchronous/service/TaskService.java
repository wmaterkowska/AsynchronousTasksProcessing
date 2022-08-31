package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskExecutor;
import com.example.asynchronous.data.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {

        /*
        Iterable<Task> tasks = this.taskRepository.findAll();
        List<Task> taskList = new ArrayList<>();
        tasks.forEach(task ->{taskList.add(task);});
        return taskList;
        */
        return this.taskRepository.findAll();
    }


    public void addTask(int base, int exponent) throws InterruptedException, ExecutionException {
        final Task newTask = Task.builder().base(base).exponent(exponent).build();
        this.taskRepository.save(newTask);

        final TaskExecutor newTaskExecutor = new TaskExecutor(this.taskRepository);

        CompletableFuture<Void> future = new CompletableFuture<>().runAsync( ()-> {
            try{
                newTaskExecutor.calculateResult(newTask);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
