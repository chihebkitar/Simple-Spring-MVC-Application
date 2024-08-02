package com.course.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
// using maven package to generate executable jar file under target , run it by java -jar name.jar
// we can deployed to cloud after that all u need jvm in cloud