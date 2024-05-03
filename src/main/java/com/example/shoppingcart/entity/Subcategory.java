package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name="Subcategory")
@Table(name="subcategoty")
@Data
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subcategotyId;

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JoinColumn(name="specificationsList")
//    private List<Specification> specifications = new ArrayList<>();
}
