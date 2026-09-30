package com.reis.reisworkshop.service;

import com.reis.reisworkshop.entities.Order;
import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.repository.OrderRepository;
import com.reis.reisworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(long id){
        //User user = service.findById(id);
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();

    }
}
