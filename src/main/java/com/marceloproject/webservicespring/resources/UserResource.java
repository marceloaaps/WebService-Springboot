package com.marceloproject.webservicespring.resources;

import com.marceloproject.webservicespring.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Carl", "cj@gmail.com", "222222222", "12345");
        return ResponseEntity.ok().body(u);
    }
}
