package com.marceloproject.webservicespring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@OpenAPIDefinition
public class WebServiceSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceSpringApplication.class, args);
    }

}
