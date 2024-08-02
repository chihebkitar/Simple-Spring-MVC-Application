package com.course.demo.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// limits the scan to our controller and auto configures mockmvc
@WebMvcTest(HelloController.class)
public class HelloControllerMockMVCTest {
    // integration test

    @Autowired // inject the mockmvc instance
    private MockMvc mvc;


    @Test
    void autowiringWorked(){
        assertNotNull(mvc);
        // to check is the aw works
    }
    @Test
    void testHelloWithoutName() throws Exception{
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user","world"));
    }

    @Test
    void testHelloWithName() throws Exception{
        mvc.perform(get("/hello?name={name}","Dolly"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user","Dolly"));
    }


}

