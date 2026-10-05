package com.reis.reisworkshop.repository;

import com.reis.reisworkshop.entities.OrderItem;
import com.reis.reisworkshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
