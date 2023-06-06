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
public class DesignTacoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showDesignFormTest() throws Exception {
        mockMvc.perform(get("/design")).andExpect(status().isOk())
        .andExpect(status().isOk())
        .andExpect(view().name("/design"))
        .andExpect(content().string(Matchers.containsString("Design your taco!")));
    }
}
