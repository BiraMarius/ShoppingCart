package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="CartItem")
@Table(name="cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_id")
    private Product product;

//    @Column
//    private String name;
//
//    @Column
//    private String brand;
//
//    @Column
//    private String smallDescription;

    @Column
    private int amount;

    @Column
    private BigDecimal totalPerItemType;
}
