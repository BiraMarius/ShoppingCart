package com.example.shoppingcart.entity;

import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    @Column
    private int amount;
}
