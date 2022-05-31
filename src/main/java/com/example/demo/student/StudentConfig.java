package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            // remove the id in the constructor because database will create it
            Student paul = new Student("Paul",
                    "paul@gmail.com", LocalDate.of(1986, 7, 1));

            Student alex = new Student("Alex",
                    "Alex@gmail.com", LocalDate.of(1990, 1, 25));

            repository.saveAll(List.of(paul, alex));
        };
    }
}
