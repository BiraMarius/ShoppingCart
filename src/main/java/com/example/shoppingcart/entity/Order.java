package com.example.shoppingcart.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToOne
    @JoinColumn(name="courierId", referencedColumnName = "courierId")
    private Courier courier;

    @Column
    private long StatusId;


    private LocalDateTime dateTime;

}
