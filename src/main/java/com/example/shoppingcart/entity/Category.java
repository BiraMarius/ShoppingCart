package com.example.shoppingcart.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @OneToMany
    @JoinColumn(name = "subCategoryId", referencedColumnName = "subCategoryId")
    private List<Subcategory> subcategories;

    @Column
    private String Name;

}
