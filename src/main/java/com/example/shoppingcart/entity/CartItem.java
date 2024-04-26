package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String smallDescription;

    @Column
    private int amount;

    @Column
    private BigDecimal totalPerItemType;
}
