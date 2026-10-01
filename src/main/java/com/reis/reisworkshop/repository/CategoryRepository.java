package com.reis.reisworkshop.repository;

import com.reis.reisworkshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(long id);
}
