package de.vkononenko.TacoCloud.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showOrderTest() throws Exception {
        mockMvc.perform(get("/completeOrder")).andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(view().name("/completeOrder"))
                .andExpect(content().string(Matchers.containsString("Complete order")));
    }
}
