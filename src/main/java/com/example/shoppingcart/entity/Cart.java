package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cart")
@Table(name = "cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToMany(
            mappedBy="cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CartItem> cartItemList = new ArrayList<>();

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cart_id")
//    private Client client;

    @OneToOne(mappedBy = "cart")
    private Order Order;


    @Column
    private BigDecimal total;

    //add for cart item amount and price (calculating price by amount)
}
