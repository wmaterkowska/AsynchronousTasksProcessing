package com.example.asynchronous.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
public class TaskExecutor {

    private TaskRepository taskRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
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
