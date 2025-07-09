package com.example.spring.data.jpa.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="jpa_order")
public class Order {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // look at database and adopt a strategy
    private Long id;


    @Column(name = "quantity", nullable = false)
    private int totalQuantity;

    @Column(name="price", nullable = false)
    private BigDecimal totalPrice;

    private boolean status;

    @Column(name="order_email", unique = true)
    private String email;

    @CreationTimestamp // from hibernate
    private LocalDateTime dateCreated;

    public Order(){
        System.out.println("Order Entity Object created");
    }

    public Order(Long id, int totalQuantity, BigDecimal totalPrice, boolean status, String email) {
        this.id = id;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalQuantity=" + totalQuantity +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}