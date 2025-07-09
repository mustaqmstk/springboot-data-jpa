package com.example.spring.data.jpa;

import com.example.spring.data.jpa.custom.exception.ResourceNotFoundException;
import com.example.spring.data.jpa.entities.Order;
import com.example.spring.data.jpa.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderRestController {
    private OrderService service;

    public OrderRestController(@Autowired OrderService service) {
        this.service = service;
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("id") Long id) {
        try {
            Order order = service.findOrderById(id);
            return ResponseEntity.ok(order);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
