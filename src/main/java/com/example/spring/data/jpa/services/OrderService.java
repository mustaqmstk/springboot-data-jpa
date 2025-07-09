package com.example.spring.data.jpa.services;

import com.example.spring.data.jpa.custom.exception.ResourceNotFoundException;
import com.example.spring.data.jpa.entities.Order;
import com.example.spring.data.jpa.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository repository;

    public OrderService(@Autowired OrderRepository repository){
        this.repository = repository;

    }

    // Method to save Order Entity
    public Order saveOrder(Order order){
        Order newOrder = repository.save(order);
        return newOrder;
    }

    public List<Order> findAll(){
        List<Order> list = this.repository.findAll();
        return list;
    }

    public Order findOrderById(Long id) throws ResourceNotFoundException {
        Optional<Order> optional = this.repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new ResourceNotFoundException("Order Object not found");
    }
}