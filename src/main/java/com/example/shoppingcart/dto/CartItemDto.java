package com.example.shoppingcart.dto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {

    private long cartItemId;

    private long productId;

    private long cartId;

    private String name;

    private String smallDescription;

    private String brand;

    private int amount;

    private BigDecimal totalPerItemType;
    private BigDecimal pricePerItem;
    private String description;

}
