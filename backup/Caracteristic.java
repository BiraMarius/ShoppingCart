package com.example.shoppingcart.entity;

import jakarta.persistence.*;

@Entity
@Table(name="caracteristic")
public class Caracteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long caracteristicId;

    @Column
    private String weight;

    @Column
    private String dimenssions;

//    @OneToOne(mappedBy = "caracteristic")
//    private Product product;
}
