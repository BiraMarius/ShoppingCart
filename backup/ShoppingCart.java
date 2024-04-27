package com.example.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shoppingCartId;

//    @OneToOne
//    @JoinColumn(name="orderId", referencedColumnName = "orderId")
//    private Order order;

//    @OneToMany
//    @JoinColumn(name = "cartItemId", referencedColumnName = "cartItemId")
//    private List<CartItem> cartItemList;

    @Column
    private BigDecimal totalPrice;

}
