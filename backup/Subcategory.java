package com.example.shoppingcart.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subCategoryId;

//    @OneToMany
//    @JoinColumn(name = "specificationId", referencedColumnName = "specificationId")
//    private List<Specification> specifications;

    @Column
    private String name;
}
