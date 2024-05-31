package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="Product")
@Table(name="product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
   //@JoinColumn(name = "Caracteristics", referencedColumnName = "caracteristicsId")
    private Caracteristics caracteristics;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

//    @OneToOne(mappedBy = "product")
//    private CartItem cartItem;

    @Column
    private String name;

    @Column
    public String brand;

    @Column
    private String description;

    @Column
    private String smallDescription;

    @Column
    private BigDecimal price;

    @Column
    private long stock;
}
