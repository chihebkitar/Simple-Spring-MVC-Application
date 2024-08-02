package com.course.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// regular controller we forward it vie
// in rest controller we return an object @response body
//will auto serialized to json data
// using web started jason starter dep
//sb will do the config
@RestController
public class HelloRestController {


    @GetMapping("/rest")
    public Greeting greet(@RequestParam(defaultValue = "world") String name){
        return new Greeting("hello, "+name+"!");
    }
}

// java 16 + feature
// record is data holder
// allows us to put data in object
// immutable
// auto generate tostring equals hashcode methods
// constructor outside
// no setters
record Greeting(String message){}
