package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Product;

import com.example.shoppingcart.exceptions.ProductNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

//    private final ProductRepository productRepository;
//
//    private Product findProductById(long id){
//        Optional<Product> product = productRepository.findById(id);
//        if(product.isPresent()){
//            return product.get();
//        } else {
//            throw new ProductNotFoundException("Product not found!");
//        }
//    }


}
