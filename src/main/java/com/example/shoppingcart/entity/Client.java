package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    //cascade give error
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="walletsList")
    private List<Wallet> wallets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="addressesList")
    private List<Address> adresses;

//    @OneToOne(mappedBy = "client")
//    private Favorite favorite;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String email;

}
