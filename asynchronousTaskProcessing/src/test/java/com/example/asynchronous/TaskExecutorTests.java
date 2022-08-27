package com.example.asynchronous;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskExecutorTests {

    @Mock
    private TaskExecutor taskExecutor;

    @Test
    public void calculateResultTest() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(3).build();
        this.taskExecutor.calculateResult();
        assertEquals(8, task.getResult());
    }

    @Test
    public void calculateResultTestWithExponentZero() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(0).build();
        this.taskExecutor.calculateResult();
        assertEquals(1, task.getResult());
    }

    @Test
    public void calculateResultTestWithBaseZero() throws InterruptedException {
        Task task = Task.builder().base(0).exponent(15).build();
        this.taskExecutor.calculateResult();
        assertEquals(0, task.getResult());
    }

}
