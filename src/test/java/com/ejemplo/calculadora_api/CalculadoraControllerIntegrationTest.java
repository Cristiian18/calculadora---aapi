package com.ejemplo.calculadora_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSumarEndpoint() throws Exception {
        mockMvc.perform(get("/sumar")
                .param("a", "10")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }
    
    @Test
    public void testDividirEndpoint() throws Exception {
        mockMvc.perform(get("/dividir")
                .param("a", "10")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }
    
    @Test
    public void testDividirPorCeroEndpoint() throws Exception {
        mockMvc.perform(get("/dividir")
                .param("a", "10")
                .param("b", "0"))
                .andExpect(status().isBadRequest());
    }
}
