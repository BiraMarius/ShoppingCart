package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.repository.CartItemRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartItemMapper {
    private final ProductMapper productMapper;
    private final CartItemRepository cartItemRepository;

    public CartItemMapper(ProductMapper productMapper, CartItemRepository cartItemRepository) {
        this.productMapper = productMapper;
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem cartItemFromItemDto(ItemDto itemDto){
        ProductDto productDto = itemDto.getProductDto();
        CartItem cartItem = new CartItem();
        cartItem.setAmount(itemDto.getAmount());
        cartItem.setTotalPerItemType(BigDecimal.valueOf(0));//TODO CALCULATE VALUE

        cartItem.setProduct(productMapper.productFromDto(productDto));
        return cartItem;
    }

    public CartItemDto entityToDto(CartItem cartItem){
        return CartItemDto.builder()
                .cartId(cartItem.getCart().getCartId())
                .productId(cartItem.getProduct().getProductId())
                .name(cartItem.getProduct().getName())
                .brand(cartItem.getProduct().getBrand())
                .smallDescription(cartItem.getProduct().getSmallDescription())
                .amount(cartItem.getAmount())
                .totalPerItemType(cartItem.getTotalPerItemType())
                .build();
    }
}
