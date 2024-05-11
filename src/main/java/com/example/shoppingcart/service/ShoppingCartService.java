package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.mapper.ProductMapper;

import com.example.shoppingcart.repository.ClientRepository;
import com.example.shoppingcart.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

@Service
@AllArgsConstructor
@ComponentScan("com.example.shoppingcart")
public class ShoppingCartService {
    private final ProductMapper productMapper;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ClientRepository clientRepository;

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

    public void cartDetails(long clientId){
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if(optionalClient.isPresent()){
            Optional<Cart> optionalCart = shoppingCartRepository.findById(optionalClient.get().getClientId());
        }

    }

    public void insertIntoCart(){
        Cart cart = new Cart();
        CartItem cartItem = new CartItem();
        CartItem cartItem2 = new CartItem();

        cartItem.setAmount(10);
        cartItem.setTotalPerItemType(BigDecimal.valueOf(100));
        cartItem.setCart(cart);

        cartItem2.setAmount(20);
        cartItem2.setTotalPerItemType(BigDecimal.valueOf(200));
        cartItem2.setCart(cart);

        cart.setTotal(BigDecimal.valueOf(0));
        cart.setCartItemList(Arrays.asList(cartItem, cartItem2));
        shoppingCartRepository.save(cart);
    }

    public void insertItemIntoCart(){
        //cantitate
        //productID
        //1 - Obiect tip CartItem
        //2 - Adaug CartItem la obiectul Cart
        //- Select in baza de date sa vezi detaliile cartului tau
        //- daca cartul exista atunci adauga la lista de cartItem si item-ul curent
        //- daca nu exista fa un obiect de tip cart un obiect de tip cart item si se repteta logica de sus
    }

    public void inShoppingcart(){
        Cart cart = new Cart();

    }

    public CartItemDto productToCartItemDto(){

    }




}
