package com.example.shoppingcart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    //ShoppingCart findByShoppingCartId(long shoppingCartId);


}
