package com.marceloproject.webservicespring.repositories;

import com.marceloproject.webservicespring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
