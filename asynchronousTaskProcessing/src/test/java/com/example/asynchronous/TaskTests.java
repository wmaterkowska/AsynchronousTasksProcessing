package com.example.asynchronous;

import com.example.asynchronous.data.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {

    @Test
    public void calculateResultTest() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(3).build();
        task.calculateResult();
        assertEquals(8, task.getResult());
    }

    @Test
    public void calculateResultTestWithExponentZero() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(0).build();
        task.calculateResult();
        assertEquals(1, task.getResult());
    }

    @Test
    public void calculateResultTestWithBaseZero() throws InterruptedException {
        Task task = Task.builder().base(0).exponent(15).build();
        task.calculateResult();
        assertEquals(0, task.getResult());
    }

}
