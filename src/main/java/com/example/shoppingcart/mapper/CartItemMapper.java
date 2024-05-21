package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.ItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartItemMapper {
    private final ProductMapper productMapper;
    private final Cart

    public CartItemMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public CartItem cartItemFromItemDto(ItemDto itemDto){
        ProductDto productDto = itemDto.getProductDto();
        CartItem cartItem = new CartItem();
        cartItem.setAmount(itemDto.getAmount());
        cartItem.setTotalPerItemType(BigDecimal.valueOf(0));//TODO CALCULATE VALUE
        cartItem.setProduct(productMapper.productFromDto(productDto));

        return cartItem;
    }
}
