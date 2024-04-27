package com.example.shoppingcart.util.functions;

import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class Functions {

    private final ProductMapper productMapper;

//    public CartItemDto productToCartItemDto(Product product){
//        ProductDto productDto = productMapper.entityToDto(product);
//        CartItemDto cartItemDto = new CartItemDto();
//        cartItemDto.setProductId(productDto.getProductId());
//        cartItemDto.setName(productDto.getName());
//        cartItemDto.setTotalPerItemType(productDto.getPrice()); //TODO: Insert a method that calculates the total using amount
//                                                                // when amount is ready
//        cartItemDto.setBrand(productDto.getBrand());
//        cartItemDto.setSmallDescription(productDto.getSmallDescription());
//        return cartItemDto;
//    }


//    public boolean isInStock(Product product, int amount){
//        if (amount <= product.getStock()){
//            return true;
//        } else return false;
//    }
}
