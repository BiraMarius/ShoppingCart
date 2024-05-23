package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Specification")
@Table(name="specification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long specificationId;

    @Column
    private String specificationName;

    @Column
    private String specificationValue;
}
