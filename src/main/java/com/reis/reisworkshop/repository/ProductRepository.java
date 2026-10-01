package com.reis.reisworkshop.repository;

import com.reis.reisworkshop.entities.Category;
import com.reis.reisworkshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(long id);
}
