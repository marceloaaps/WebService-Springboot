package com.marceloproject.webservicespring.repositories;

import com.marceloproject.webservicespring.entities.Category;
import com.marceloproject.webservicespring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
