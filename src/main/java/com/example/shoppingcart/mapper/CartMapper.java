package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.CartDto;
import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Cart;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartMapper {

    public CartItemDto productToCartItemDtoForCart(ProductDto productDto){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(productDto.getProductId());
        cartItemDto.setName(productDto.getName());
        cartItemDto.setBrand(productDto.getBrand());
        cartItemDto.setSmallDescription(productDto.getSmallDescription());
        cartItemDto.setDescription(productDto.getDescription());
        cartItemDto.setTotalPerItemType(BigDecimal.valueOf(0));
        cartItemDto.setPricePerItem(productDto.getPrice());
        cartItemDto.setAmount(0);
        return cartItemDto;
    }

    public CartDto cartToDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setTotal(cart.getTotal());
        cartDto.setCartItemList(cart.getCartItemList());
        cartDto.setOrder(cart.getOrder());
        cartDto.setClient(cart.getClient());
        return  cartDto;
    }

    public Cart dtoToEntity(CartDto cartDto){
        Cart cart = new Cart();
        cart.setCartItemList(cartDto.getCartItemList());
        cart.setTotal(cartDto.getTotal());
        cart.setOrder(cartDto.getOrder());
        cart.setClient(cartDto.getClient());
        return cart;
    }

}
