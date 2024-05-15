package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="Address")
@Table(name="address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @ManyToOne
    private Client client;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String stateCountySector;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String zip;

    @Column
    private String building;

    @Column
    private String entryNo;

    @Column
    private String floor;

    @Column
    private String apartament;

    @Column
    private String interphone;

}
