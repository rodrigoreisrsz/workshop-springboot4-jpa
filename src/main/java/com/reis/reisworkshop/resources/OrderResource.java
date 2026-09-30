package com.reis.reisworkshop.resources;

import com.reis.reisworkshop.entities.Order;
import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.service.OrderService;
import com.reis.reisworkshop.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    private final OrderService service;


    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list =  service.findAll();
        return  ResponseEntity.ok(list);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable long id){
        Order order = service.findById(id);
        return ResponseEntity.ok(order);
    }

}
