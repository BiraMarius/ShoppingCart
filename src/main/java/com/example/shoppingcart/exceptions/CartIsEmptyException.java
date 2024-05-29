package com.example.shoppingcart.exceptions;

public class CartIsEmptyException extends RuntimeException{
    public CartIsEmptyException(String message) {
        super(message);
    }}
