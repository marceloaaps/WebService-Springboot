package com.marceloproject.webservicespring.config;


import com.marceloproject.webservicespring.entities.User;
import com.marceloproject.webservicespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Joaquina", "maria@gmail.com", "988881111", "123456");
        User u2 = new User(null, "Alek Fumasa", "alex@gmail.com", "940028922", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
