package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "caracteristicId", referencedColumnName = "caracteristicId")
    private Caracteristic caracteristic;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String description;

    @Column
    private String smallDescription;

    @Column
    private BigDecimal price;

    @Column
    private long stock;
}
