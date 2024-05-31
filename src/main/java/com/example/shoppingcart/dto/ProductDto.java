package com.example.shoppingcart.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private long productId;

    private long caracteristicId;

    private long categoryId;

    private String name;

    private String brand;

    private String description;

    private String smallDescription;

    private BigDecimal price;

    private long stock;

}
