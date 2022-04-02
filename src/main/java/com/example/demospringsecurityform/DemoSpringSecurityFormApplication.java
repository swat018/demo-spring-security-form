package com.example.demospringsecurityform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoSpringSecurityFormApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 비추천
//        return NoOpPasswordEncoder.getInstance();
        // 추천
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityFormApplication.class, args);
    }

}
