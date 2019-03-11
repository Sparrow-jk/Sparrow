package com.sparrow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sparrow
 * @apiNote  @SpringBottApplication =
 * EnableAutoConfiguration + SpringbootConfiguration + ComponentScan
 */
@SpringBootApplication
public class SparrowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparrowApplication.class, args);

    }
}
