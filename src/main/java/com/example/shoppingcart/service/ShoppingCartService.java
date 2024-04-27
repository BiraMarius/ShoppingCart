package com.example.shoppingcart.service;

import com.example.shoppingcart.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ComponentScan("com.example.shoppingcart")
public class ShoppingCartService {
//    private final ProductMapper productMapper;
//    private final ShoppingCartRepository shoppingCartRepository;

//    public CartItemDto addToCartItemDto(long shoppingCartId, Product product){
//        List<CartItem> productsInCart = shoppingCartRepository.findByShoppingCartId(shoppingCartId).getCartItemList();
//        CartItemDto cartItemDto = productMapper.cartItemToDto(productMapper.cartItemToEntity(product));
//        productsInCart.add(productMapper.cartItemToEntity(product));
//        shoppingCartRepository.save(shoppingCartRepository.findByShoppingCartId(shoppingCartId));
//        return cartItemDto;
//    }
//
//    public CartItemDto removeOneCartItem(long shoppingCartId, CartItemDto cartItemDto){
//        List<CartItem> productsInCart = shoppingCartRepository.findByShoppingCartId(shoppingCartId).getCartItemList();
//        CartItemDto cartItem = productMapper.cartItemToDto(productsInCart.stream()
//                .filter(item -> item.getCartItemId() == Long.valueOf(cartItemDto.getCartItemId()))
//                .findFirst()
//                .get());
//        int amount = cartItem.getAmount();
//        cartItem.setAmount(amount-1);
//        return cartItem;
//    }
//
//    public CartItemDto addOneCartItem(long shoppingCartId, CartItemDto cartItemDto){
//        List<CartItem> productsInCart = shoppingCartRepository.findByShoppingCartId(shoppingCartId).getCartItemList();
//        CartItemDto cartItem = productMapper.cartItemToDto(productsInCart.stream()
//                .filter(item -> item.getCartItemId() == Long.valueOf(cartItemDto.getCartItemId()))
//                .findFirst()
//                .get());
//        int amount = cartItem.getAmount();
//        cartItem.setAmount(amount+1);
//        return cartItem;
//    }




}
