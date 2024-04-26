package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //List<CartItem> findAllByShoppingCartId(long shoppingCartId);

    List<Product> findAllByStockGreaterThan(int stock);
}
