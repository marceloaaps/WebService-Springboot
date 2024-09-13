package com.marceloproject.webservicespring.repositories;

import com.marceloproject.webservicespring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
