package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.ShoppingCart;
import com.example.shoppingcart.exceptions.ProductNotFoundException;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.util.functions.Functions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private Product findProductById(long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        } else {
            throw new ProductNotFoundException("Product not found!");
        }
    }


}
