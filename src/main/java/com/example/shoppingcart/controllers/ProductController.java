package com.example.shoppingcart.controllers;

import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductMapper productMapper, ProductService productService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @PostMapping("/add-product-in-db")
    public String addProduct(@RequestBody ProductDto productDto){
        productRepository.save(productMapper.productFromDto(productDto));
        return "Product added to database.";
    }

    @PostMapping("/post-product-list-db")
    public String productDatabase(@RequestBody List<ProductDto> products){
        productService.addProductsToDb(products);
        return "Product list added.";
    }
}
