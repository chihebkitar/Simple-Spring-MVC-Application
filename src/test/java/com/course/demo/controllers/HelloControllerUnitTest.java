package com.course.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerUnitTest {

    @Test
    void sayHello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("Dolly",model);
//        assertEquals("welcome",result);
//        assertEquals("Dolly",model.getAttribute("user"));
        // asmap.get or getattribute
        // assert equals not best approach if the first test fail the second will auto fail
        // so we use assert all
        assertAll(
                ()-> assertEquals("welcome",result),
                ()-> assertEquals("Dolly",model.getAttribute("user"))
        );
        // set of executables
        //assert equals returns (void) so null
    }
}