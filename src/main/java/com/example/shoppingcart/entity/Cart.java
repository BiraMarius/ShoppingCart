package com.example.shoppingcart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @Column
    //add foreign key
    private long clientId;

    @Column
    //add foreign key
    private long orderId;

    @Column
    private BigDecimal total;

    //add for cart item amount and price (calculating price by amount)
}
