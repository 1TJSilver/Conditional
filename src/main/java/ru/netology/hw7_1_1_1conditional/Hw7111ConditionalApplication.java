package ru.netology.hw7_1_1_1conditional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Hw7111ConditionalApplication {
    public String from;
    public static void main(String[] args) {
        SpringApplication.run(Hw7111ConditionalApplication.class, args);
    }
}
