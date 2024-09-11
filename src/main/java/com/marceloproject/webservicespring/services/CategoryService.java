package com.marceloproject.webservicespring.services;

import com.marceloproject.webservicespring.entities.Category;
import com.marceloproject.webservicespring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryService repository;

    public List<Category> findAll(){

        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = Optional.ofNullable(repository.findById(id));
        return obj.get();
    }
}
