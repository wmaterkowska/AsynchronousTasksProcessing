package com.example.asynchronous;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.service.TaskService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Test
    @Order(1)
    public void getAllTasksInitiallyTest() {
        this.taskService.cleanRepository();
        assertTrue(this.taskService.getAllTasks().isEmpty());
    }

    @SneakyThrows
    @Test
    @Order(2)
    public void addTaskTest() {
        int baseTest = 2;
        int exponentTest = 3;
        this.taskService.addTask(baseTest, exponentTest);
        assertNotNull(this.taskService.getAllTasks());
    }

    @Test
    public void calculateResultTest() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(3).build();
        this.taskService.calculateResult(task);
        assertEquals(8, task.getResult());
    }

    @Test
    public void calculateResultTestWithExponentZero() throws InterruptedException {
        Task task = Task.builder().base(2).exponent(0).build();
        this.taskService.calculateResult(task);
        assertEquals(1, task.getResult());
    }

    @Test
    public void calculateResultTestWithBaseZero() throws InterruptedException {
        Task task = Task.builder().base(0).exponent(15).build();
        this.taskService.calculateResult(task);
        assertEquals(0, task.getResult());
    }



}
