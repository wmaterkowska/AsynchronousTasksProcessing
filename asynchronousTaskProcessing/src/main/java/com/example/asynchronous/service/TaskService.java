package com.example.asynchronous.service;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

        log.info("list of tasks: " + this.taskRepository.findAll());
        return this.taskRepository.findAll();
    }

    public void cleanRepository(){
        this.taskRepository.deleteAll();
    }

    /**
     * add task to the database (initiate calculating of the result of the task)
     * @param base integer
     * @param exponent integer
     */
    public void addTask(int base, int exponent) {
        final Task newTask = Task.builder().base(base).exponent(exponent).build();
        this.taskRepository.save(newTask);

        new CompletableFuture<>().runAsync( ()-> {
            try{
                this.calculateResult(newTask);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("task added, calculating started");
    }

    public void calculateResult(Task task) throws InterruptedException {
        long currentResult = 1;
        for (int i = 1; i <= task.getExponent(); i++){
            Thread.sleep(1000);
            task.setStatus( ((float) i / task.getExponent()) * 100);
            currentResult = task.getBase() * currentResult;
            taskRepository.save(task);
        }
        task.setResult(currentResult);
        this.taskRepository.save(task);
    }

}
