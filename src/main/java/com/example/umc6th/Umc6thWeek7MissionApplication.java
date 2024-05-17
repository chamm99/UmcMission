package com.example.umc6th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Umc6thWeek7MissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Umc6thWeek7MissionApplication.class, args);
    }

}
