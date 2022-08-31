package com.example.asynchronous.data;

public class TaskExecutor {

    private final TaskRepository taskRepository;

    public TaskExecutor(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * calculate the result for the task, base^exponent
     * @param task
     * @throws InterruptedException
     */
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
