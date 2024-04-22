package com.example.shoppingcart.dto;


import com.example.shoppingcart.entity.Caracteristic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private long productId;

    private long caracteristicId;

    private long categoryId;

    private String name;

    private String brand;

    private String description;

    private BigDecimal price;


}
