package com.example.asynchronous;

import com.example.asynchronous.service.TaskService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Test
    @Order(1)
    public void getAllTasksTest() {
        assertTrue(this.taskService.getAllTasks().isEmpty());
    }

    @Test
    @Order(2)
    @SneakyThrow
    public void addTaskTest() {
        int baseTest = 2;
        int exponentTest = 3;
        this.taskService.addTask(baseTest, exponentTest);
        assertNotNull(this.taskService.getAllTasks());
    }

}
