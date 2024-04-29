package com.example.shoppingcart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="cartItem")
    private List<CartItem> cartItemList = new ArrayList<>();

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
