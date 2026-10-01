package com.reis.reisworkshop.resources;

import com.reis.reisworkshop.entities.Product;
import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.service.ProductService;
import com.reis.reisworkshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    private final ProductService service;


    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list =  service.findAll();
        return  ResponseEntity.ok(list);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        Product product = service.findById(id);
        return ResponseEntity.ok(product);
    }

}
