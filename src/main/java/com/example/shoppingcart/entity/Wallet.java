package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="Wallet")
@Table(name = "wallet")
@Data
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long walletId;

    @ManyToOne
    private Client client;

    @Column
    private String cardNo;

    @Column
    private String expirationDate;

    @Column
    private String cvv;

    @Column
    private String nameOnCard;
}
