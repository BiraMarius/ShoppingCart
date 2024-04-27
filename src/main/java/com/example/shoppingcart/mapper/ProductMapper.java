package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    //                NOT USED !!!!
//    public ProductDto entityToDto(Product product){
//        ProductDto productDto = new ProductDto();
//        productDto.setProductId(product.getProductId());
//        productDto.setName(product.getName());
//        productDto.setBrand(product.getBrand());
//        productDto.setDescription(product.getDescription());
//        productDto.setPrice(product.getPrice());
//        productDto.setSmallDescription(productDto.getSmallDescription());
//        return productDto;
//    }

//    public Product productDtoToEntity(CartItemDto cartItemDto){
//        Product product = new Product();
//        product.setProductId(cartItemDto.getProductId());
//        product.setName(cartItemDto.getName());
//        product.setBrand(cartItemDto.getBrand());
//        product.setSmallDescription(cartItemDto.getSmallDescription());
//        product.setPrice(cartItemDto.getPricePerItem());
//        product.setDescription(cartItemDto.getDescription());
//        return product;
//    }
//
//    public CartItem cartItemToEntity(Product product){
//        CartItem cartItem = new CartItem();
//        //cartItem.setProduct(product);
//        cartItem.setName(product.getName());
//        cartItem.setBrand(product.getBrand());
//        cartItem.setSmallDescription(product.getSmallDescription());
//        cartItem.setTotalPerItemType(product.getPrice());
//        return cartItem;
//    }
//
//    public CartItemDto cartItemToDto(CartItem cartItem){
//        CartItemDto cartItemDto = new CartItemDto();
//        //cartItemDto.setProductId(cartItem.getProduct().getProductId());
//        cartItemDto.setBrand(cartItem.getBrand());
//        cartItemDto.setName(cartItem.getName());
//        cartItemDto.setSmallDescription(cartItem.getSmallDescription());
//        return cartItemDto;
//    }

}
