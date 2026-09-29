package com.reis.reisworkshop.repository;

import com.reis.reisworkshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
