package com.course.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
    // controllers receive http requests and return
    // http response or redirect u to another vue



    // maps to http://localhost:8080/hello?name=adam(query param)
    @GetMapping("/hello")  // when spring app receive http get request it should revoke this method
    public String sayHello(@RequestParam(defaultValue = "world") String name, // if dont provide name use default value
                           Model model){ // model is map collection of keys and values
        // model : spring will take keys and values add it to http request
        model.addAttribute("user",name);
        return  "welcome"; // forward to src/ main /resources/ templates/ welcome.html
    }
}
