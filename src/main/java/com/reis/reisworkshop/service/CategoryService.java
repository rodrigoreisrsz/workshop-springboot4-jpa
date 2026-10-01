package com.reis.reisworkshop.service;

import com.reis.reisworkshop.entities.Category;
import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.repository.CategoryRepository;
import com.reis.reisworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(long id){
        //User user = service.findById(id);
        Optional<Category> obj = repository.findById(id);
        return obj.get();

    }
}
