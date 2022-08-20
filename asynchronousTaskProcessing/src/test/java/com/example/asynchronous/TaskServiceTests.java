package com.example.asynchronous;

import com.example.asynchronous.data.Task;
import com.example.asynchronous.service.TaskService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TaskServiceTests {

    private TaskService taskService;

    @Test
    public void listAllTasksTest(){
        assertNull(this.taskService.listAllTasks());
    }
}
