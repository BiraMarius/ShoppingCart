package com.example.shoppingcart.exceptions;

import com.example.shoppingcart.entity.Product;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
