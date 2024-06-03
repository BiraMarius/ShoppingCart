package com.example.shoppingcart.controllers;

import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.service.ProductService;
import com.example.shoppingcart.specification.SearchCriteria;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/products")
    public List<ProductDto> listOfAvailableProducts(){
        return productService.mapperForProductList(productRepository.findAll());
    }

    @GetMapping("/get-products-by-criteria")
    public List<ProductDto> findByCriteria(@RequestBody SearchCriteria criteria){
        return productService.getProductByCriteria(criteria);
    }

    @GetMapping("/get-available-stock-products")
    public List<ProductDto> findAvailableProducts(){
        return productService.getAvailableProductsInStock();
    }


}
