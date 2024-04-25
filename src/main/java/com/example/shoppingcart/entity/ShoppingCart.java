package com.example.shoppingcart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shoppingCartId;

    @OneToOne
    @JoinColumn(name="orderId", referencedColumnName = "orderId")
    private long orderId;

    @OneToMany
    @JoinColumn(name = "cartItemId", referencedColumnName = "cartItemId")
    private List<CartItem> cartItemId;

    @Column
    private BigDecimal totalPrice;

}
