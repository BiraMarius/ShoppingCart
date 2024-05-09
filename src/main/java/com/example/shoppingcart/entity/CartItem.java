package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="CartItem")
@Table(name="cart_item")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;


//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Product_id")
//    private Product product;

    @Column
    private int amount;

    @Column
    private BigDecimal totalPerItemType;
}
