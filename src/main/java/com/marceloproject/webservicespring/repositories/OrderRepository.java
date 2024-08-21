package com.marceloproject.webservicespring.repositories;

import com.marceloproject.webservicespring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
