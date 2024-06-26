package com.example.shoppingcart.entity;

import jakarta.persistence.*;

@Entity
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specificationId;

    @Column
    private String name;

    @Column
    private String value;
}
