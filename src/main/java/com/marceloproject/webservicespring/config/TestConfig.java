package com.marceloproject.webservicespring.config;


import com.marceloproject.webservicespring.entities.Category;
import com.marceloproject.webservicespring.entities.Order;
import com.marceloproject.webservicespring.entities.Product;
import com.marceloproject.webservicespring.entities.User;
import com.marceloproject.webservicespring.entities.enums.OrderStatus;
import com.marceloproject.webservicespring.repositories.CategoryRepository;
import com.marceloproject.webservicespring.repositories.OrderRepository;
import com.marceloproject.webservicespring.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args){

        Category c1 = new Category(null, "Eletronicos");
        Category c2 = new Category(null, "Livros");
        Category c3 = new Category(null, "Móveis");


        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        Product p1 = new Product(null, "Torradeira Elétrica", "Uma descrição muito aleatória e legal", 250.00, "");
        Product p2 = new Product(null, "Sofá Cama", "Uma descrição muito aleatória e legal", 1220.00, "");
        Product p3 = new Product(null, "Game Of Thrones Vol. 1", "Uma descrição muito aleatória e legal", 90.00, "");
        Product p4 = new Product(null, "TV LG 58' 4K ", "Uma descrição muito aleatória e legal", 2250.00, "");
        Product p5 = new Product(null, "Armário do Mário", "Uma descrição muito aleatória e legal", 750.00, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Joaquina", "maria@gmail.com", "988881111", "123456");
        User u2 = new User(null, "Alek Fumasa", "alex@gmail.com", "940028922", "123456");

        Order o1 = new Order(null, Instant.parse("2024-08-21T14:52:01Z"),  OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2024-08-22T16:53:14Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o3 = new Order(null, Instant.parse("2024-06-15T21:34:55Z"), OrderStatus.WAITING_PAYMENT, u2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
