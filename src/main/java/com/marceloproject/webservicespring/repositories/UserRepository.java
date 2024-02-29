package com.marceloproject.webservicespring.repositories;

import com.marceloproject.webservicespring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
