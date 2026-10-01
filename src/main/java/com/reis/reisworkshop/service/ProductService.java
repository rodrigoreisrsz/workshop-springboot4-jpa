package com.reis.reisworkshop.service;

import com.reis.reisworkshop.entities.Category;
import com.reis.reisworkshop.entities.Product;
import com.reis.reisworkshop.repository.CategoryRepository;
import com.reis.reisworkshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(long id){
        //User user = service.findById(id);
        Optional<Product> obj = repository.findById(id);
        return obj.get();

    }
}
