package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="Caracteristics")
@Table(name="caracteristics")
public class Caracteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long caracteristicsId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_id")
    private Product product;

    @Column
    private String weight;

    @Column
    private String dimenssions;


}
