package com.example.shoppingcart.entity;

import jakarta.persistence.*;

@Entity
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courierId;

    @Column
    private String name;

    @Column
    private String awb;
}
