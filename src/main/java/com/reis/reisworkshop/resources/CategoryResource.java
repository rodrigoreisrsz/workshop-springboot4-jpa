package com.reis.reisworkshop.resources;

import com.reis.reisworkshop.entities.Category;
import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.service.CategoryService;
import com.reis.reisworkshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    private final CategoryService service;


    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list =  service.findAll();
        return  ResponseEntity.ok(list);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable long id){
        Category category = service.findById(id);
        return ResponseEntity.ok(category);
    }

}
