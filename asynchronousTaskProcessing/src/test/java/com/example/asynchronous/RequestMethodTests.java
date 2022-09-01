package com.example.asynchronous;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestMethodTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTasksHtmlTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/tasks"))
                        .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addTaskHtmlTest() throws Exception {

        mockMvc.perform(post("/tasks")
                        .param("base", "2")
                        .param("exponent", "3"))
                .andDo(print()).andExpect(status().isOk());

    }

}
