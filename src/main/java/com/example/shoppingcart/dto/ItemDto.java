package com.example.shoppingcart.dto;

import lombok.Data;

@Data
public class ItemDto {
    private ProductDto productDto;
    private int amount;
    private long clientId;
}
