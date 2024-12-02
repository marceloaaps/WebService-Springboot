package com.marceloproject.webservicespring.config;


import com.marceloproject.webservicespring.entities.*;
import com.marceloproject.webservicespring.entities.enums.OrderStatus;
import com.marceloproject.webservicespring.repositories.*;
import org.aspectj.weaver.ast.Or;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args){

        Category c1 = new Category(null, "Eletronicos");
        Category c2 = new Category(null, "Livros");
        Category c3 = new Category(null, "Móveis");

        Product p1 = new Product(null, "Torradeira Elétrica", "Uma descrição muito aleatória e legal", 250.00, "");
        Product p2 = new Product(null, "Sofá Cama", "Uma descrição muito aleatória e legal", 1220.00, "");
        Product p3 = new Product(null, "Game Of Thrones Vol. 1", "Uma descrição muito aleatória e legal", 90.00, "");
        Product p4 = new Product(null, "TV LG 58' 4K ", "Uma descrição muito aleatória e legal", 2250.00, "");
        Product p5 = new Product(null, "Armário do Mário", "Uma descrição muito aleatória e legal", 750.00, "");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(c1);
        p2.getCategories().add(c1);
        p3.getCategories().add(c1);
        p4.getCategories().add(c1);
        p5.getCategories().add(c1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Joaquina", "maria@gmail.com", "988881111", "123456");
        User u2 = new User(null, "Alek Fumasa", "alex@gmail.com", "940028922", "123456");

        Order o1 = new Order(null, Instant.parse("2024-08-21T14:52:01Z"),  OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2024-08-22T16:53:14Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o3 = new Order(null, Instant.parse("2024-06-15T21:34:55Z"), OrderStatus.WAITING_PAYMENT, u2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 4, p1.getPrice());
        OrderItem oi2 = new OrderItem(o3, p4, 6, p4.getPrice());
        OrderItem oi3 = new OrderItem(o2, p2, 4, p2.getPrice());
        OrderItem oi4 = new OrderItem(o1, p3, 7, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2024-08-21T19:52:01Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}
