package com.example.shoppingcart.dto;

import com.example.shoppingcart.entity.Address;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Favorite;
import com.example.shoppingcart.entity.Wallet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class ClientDto {

    private long clientId;

    private List<Wallet> wallets = new ArrayList<>();

    private List<Address> adresses = new ArrayList<>();

    private Favorite favorite;

    private Cart cart;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;
}
