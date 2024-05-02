package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

//    @OneToMany
//    @JoinColumn(name = "subCategoryId", referencedColumnName = "subCategoryId")
//    private List<Subcategory> subcategories;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="product_List")
    private List<Product> products = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="subcategory_List")
    private List<Subcategory> subcategories = new ArrayList<>();


    @Column
    private String Name;
}
