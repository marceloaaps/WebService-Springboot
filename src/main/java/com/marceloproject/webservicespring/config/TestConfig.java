package com.marceloproject.webservicespring.config;


import com.marceloproject.webservicespring.entities.Order;
import com.marceloproject.webservicespring.entities.User;
import com.marceloproject.webservicespring.entities.enums.OrderStatus;
import com.marceloproject.webservicespring.repositories.OrderRepository;
import com.marceloproject.webservicespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args){
        User u1 = new User(null, "Maria Joaquina", "maria@gmail.com", "988881111", "123456");
        User u2 = new User(null, "Alek Fumasa", "alex@gmail.com", "940028922", "123456");

        Order o1 = new Order(null, Instant.parse("2024-08-21T14:52:01Z"),  OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2024-08-22T16:53:14Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o3 = new Order(null, Instant.parse("2024-06-15T21:34:55Z"), OrderStatus.WAITING_PAYMENT, u2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
