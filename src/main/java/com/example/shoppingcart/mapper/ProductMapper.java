package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Product;

public class ProductMapper {
    public ProductDto entityToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setBrand(product.getBrand());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
    //TODO : Trebuie sau nu sa pun specification ID si trebuie sa fac o metoda care sa aduage specificatii intr-un produs ?

}
