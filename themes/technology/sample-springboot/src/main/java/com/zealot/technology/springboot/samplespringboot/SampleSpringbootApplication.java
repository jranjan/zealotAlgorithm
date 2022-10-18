package com.zealot.technology.springboot.samplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SampleSpringbootApplication {



    public static void main(String[] args) {
        SpringApplication.run(SampleSpringbootApplication.class, args);
    }

    @RestController
    @RequestMapping("/api/v1/students")
    class Controller {
        @GetMapping
        public List<Student> getAllStudents() {
            return List.of(
                    new Student("Tommy"),
                    new Student("Dick"),
                    new Student("Harry"),
                    new Student("Jerry")
            );
        };
    }

    class Student {
        private final String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
