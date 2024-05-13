package com.example.shoppingcart.dto;

import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.entity.Order;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CartDto {

    private long cartId;

    private List<CartItem> cartItemList = new ArrayList<>();

    private Client client;

    private com.example.shoppingcart.entity.Order Order;

    private BigDecimal total;
}
