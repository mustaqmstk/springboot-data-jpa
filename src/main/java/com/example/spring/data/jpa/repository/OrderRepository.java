package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

/**
 * The implementation of OrderRepository 'will be completed by SpringDataJPA
 * class xyz implements Order
 */


public interface OrderRepository extends JpaRepository<Order, Long>{

    // custom native queries
    // Find orders by email using a positional parameter
    @Query("SELECT o from Order o WHERE o.email = ?1")
    Order findByEmail(String email);

    // Find orders by price and name using named parameters
    @Query("SELECT o from Order o WHERE o.totalPrice = :minPrice AND o.totalPrice = :maxPrice")
    List<Order> findByPrice(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);



}