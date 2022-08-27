package com.example.asynchronous.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
public class TaskExecutor {

    private Task task;

    private TaskRepository taskRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void calculateResult() throws InterruptedException {
        long currentResult = 1;
        for (int i = 1; i <= this.task.getExponent(); i++){
            Thread.sleep(1000);
            this.task.setStatus( ((float) i / this.task.getExponent()) * 100);
            currentResult = this.task.getBase() * currentResult;
            taskRepository.save(this.task);
        }
        this.task.setResult(currentResult);
        this.taskRepository.save(task);
    }


}
