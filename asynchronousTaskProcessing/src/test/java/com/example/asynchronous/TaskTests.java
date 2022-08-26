package com.example.asynchronous;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.data.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskTests {

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void calculateResultTest() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(3).build();
        task.calculateResult(this.taskRepository);
        assertEquals(8, task.getResult());
    }

    @Test
    public void calculateResultTestWithExponentZero() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(0).build();
        task.calculateResult(this.taskRepository);
        assertEquals(1, task.getResult());
    }

    @Test
    public void calculateResultTestWithBaseZero() throws InterruptedException {
        Task task = Task.builder().base(0).exponent(15).build();
        task.calculateResult(this.taskRepository);
        assertEquals(0, task.getResult());
    }

}
