package com.course.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

// Annotation to declare that this class is a Spring Boot test which should start the server on a random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerFunctionalTest { // Start of the test class definition

    // Inject an instance of TestRestTemplate for making HTTP requests in tests
    @Autowired
    private TestRestTemplate restTemplate;

    // Define a test method to check if the TestRestTemplate was injected properly
    @Test
    void autowiringWorked(@LocalServerPort int port){
        // Assert that restTemplate is not null, ensuring it is properly autowired
        assertNotNull(restTemplate);
        // Output the port number to the console for debugging
        System.out.println("test server running on port " + port);
    }

    // Define a test method to verify functionality when the greeting endpoint is called without a name
    @Test
    void greetWithoutName(){
        // Make a GET request to "/rest" and map the response to a Greeting object
        Greeting greeting = restTemplate.getForObject("/rest", Greeting.class);
        // Ensure that the greeting object is not null
        assertNotNull(greeting);
        // Assert that the message of the greeting object is as expected
        assertEquals("hello, world!", greeting.message());
    }

    // Define a test method to verify functionality when the greeting endpoint is called with a name
    @Test
    void greetWithName(){
        // Make a GET request with a URL template and variables, and wrap the response in a ResponseEntity
        ResponseEntity<Greeting> response = restTemplate.getForEntity("/rest?name={name}", Greeting.class, "Dolly");

        // Perform multiple assertions as a group
        assertAll(
                // Assert that the response status code is 2xx, indicating success
                () -> assertTrue(response.getStatusCode().is2xxSuccessful()),
                // Assert that the content type of the response is JSON
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),
                // Assert that the message in the response body is as expected
                () -> assertEquals("hello, Dolly!", Objects.requireNonNull(response.getBody()).message())
        );

    }
}