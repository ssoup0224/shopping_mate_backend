package com.shopping_mate_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "file:.env", ignoreResourceNotFound = true)
@SpringBootApplication
public class ShoppingMateBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMateBackendApplication.class, args);
    }

}
