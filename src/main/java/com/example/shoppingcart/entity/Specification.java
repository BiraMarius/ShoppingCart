package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="Specification")
@Table(name="specification")
@Data
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long specificationId;

//    @Column
//    private String name;
//
//    @Column
//    private String value;
}
