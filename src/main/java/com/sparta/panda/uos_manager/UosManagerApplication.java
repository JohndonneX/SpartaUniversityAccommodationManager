package com.sparta.panda.uos_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class UosManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UosManagerApplication.class, args);
    }

}
