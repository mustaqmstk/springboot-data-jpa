package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long>{

    @Query("SELECT * FROM jpa_order WHERE o.email =:str")
    public Order getAllOrderByEmail(String str);
}
