package com.example.spring.data.jpa;

import com.example.spring.data.jpa.custom.exception.ResourceNotFoundException;
import com.example.spring.data.jpa.entities.Order;
import com.example.spring.data.jpa.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderRestController {

    private OrderService service;

    public OrderRestController(@Autowired OrderService service) {
        this.service = service;
    }


    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/orders/id/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("id") Long id) {
        try {
            System.out.println("value - " + id);
            Order order = service.findOrderById(id);
            return ResponseEntity.ok(order);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/orders/mail/{mail}")
    public ResponseEntity<Order> searchOrderByEmail(@PathVariable("mail") String email) {
        try {
            Order order = service.findOrderByEmail(email);
            return ResponseEntity.ok(order);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/orders")
    public ResponseEntity<Order> addNewOrder(@RequestBody Order order){
        Order newOrder = service.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

}