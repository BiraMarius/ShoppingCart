package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courierId;
}
