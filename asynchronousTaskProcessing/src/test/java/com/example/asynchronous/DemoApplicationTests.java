package com.example.asynchronous;

import com.example.asynchronous.api.TaskController;
import com.example.asynchronous.data.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	private TaskController controller;
	@Test
	void contextLoads() {
	}

}
