package com.example.studentws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentWebserviceApplication.class, args);
    }

}
