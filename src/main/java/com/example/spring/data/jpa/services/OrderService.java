package com.example.spring.data.jpa.services;

import com.example.spring.data.jpa.custom.exception.ResourceNotFoundException;
import com.example.spring.data.jpa.entities.Order;
import com.example.spring.data.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service("orderService")
public class OrderService {

    private OrderRepository repository;

    public OrderService(@Autowired OrderRepository repository) {
        this.repository = repository;

    }

    // Method to save Order Entity
    public Order saveOrder(Order order) {
        // hibernate query ??
        Order newOrder = repository.save(order);
        return newOrder;
    }

    public List<Order> findAll() {
        // hibernate query??
        List<Order> list = this.repository.findAll();
        return list;
    }

    // call findOrderById(234); // id not table
    // Optional class object works like a container which may or may not have an object
    public Order findOrderById(Long id) throws ResourceNotFoundException {
        Optional<Order> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();// return Order object
        }
        throw new ResourceNotFoundException("Order Object not found");
    }

    public Order findOrderByEmail(String email) throws ResourceNotFoundException {
        Order order = this.repository.findByEmail(email);
        if (order != null) {
            return order;
        }
        throw new ResourceNotFoundException("Resource Not Found");
    }

    public List<Order> findAllOrderBasedOnPrice(int minPrice, int maxPrice) {

        BigDecimal minPriceBigDecimal = new BigDecimal(minPrice);
        BigDecimal maxPriceBigDecimal = new BigDecimal(maxPrice);
        List<Order> list = this.repository.findByPrice(minPriceBigDecimal, maxPriceBigDecimal);
        return list;
    }

    public void deleteOrderById(Long id) {
        this.repository.deleteById(id);
    }

}