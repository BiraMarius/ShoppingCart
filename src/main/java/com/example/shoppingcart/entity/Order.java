package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Order")
@Table(name="orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="couriersList")
    private List<Courier> couriers = new ArrayList<>();

    @Column
    private String date;//change to LocalDateTime

    @Column
    private String status;//make it able to have values only from an enum
}
