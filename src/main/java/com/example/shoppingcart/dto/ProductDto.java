package com.example.shoppingcart.dto;
import com.example.shoppingcart.entity.Caracteristic;
import com.example.shoppingcart.entity.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
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
