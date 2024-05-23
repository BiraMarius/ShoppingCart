package com.example.shoppingcart.dto;

import com.example.shoppingcart.entity.Address;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private long clientId;

    private List<Wallet> wallets;

    private List<Address> adresses;

    //private Favorite favorite;

    private Cart cart;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;
}