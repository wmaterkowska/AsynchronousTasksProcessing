package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskExecutor;
import com.example.asynchronous.data.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * give list with all started tasks
     * @return List of all started tasks
     */
    public List<Task> getAllTasks() {

        /*
        Iterable<Task> tasks = this.taskRepository.findAll();
        List<Task> taskList = new ArrayList<>();
        tasks.forEach(task ->{taskList.add(task);});
        return taskList;
        */
        log.info("list of tasks: " + this.taskRepository.findAll());
        return this.taskRepository.findAll();
    }


    /**
     * add task to the database (initiate calculating of the result of the task)
     * @param base integer
     * @param exponent integer
     * @throws InterruptedException
     * @throws ExecutionException
     */
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
        log.info("task added, calculating started");
    }



}
