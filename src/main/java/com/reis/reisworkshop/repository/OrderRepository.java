package com.reis.reisworkshop.repository;

import com.reis.reisworkshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
