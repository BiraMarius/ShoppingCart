package com.example.shoppingcart.repository;


import com.example.shoppingcart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
   // Cart findByShoppingCartId(long shoppingCartId);



}
