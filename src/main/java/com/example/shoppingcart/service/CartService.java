package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.CartDto;
import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.exceptions.CartIsEmptyException;
import com.example.shoppingcart.mapper.CartItemMapper;
import com.example.shoppingcart.mapper.CartMapper;
import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.ClientRepository;
import com.example.shoppingcart.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartService {

    private final ClientRepository clientRepository;
    private final CartMapper cartMapper;
    private final CartItemMapper cartItemMapper;
    private final ProductService productService;

    public Cart findCart(long clientId){
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            if(clientOpt.get().getCart() != null){
                return clientOpt.get().getCart();
            } else {
                Cart cart = new Cart();
                return cart;
            }
        }else {
            return null;
        }
//        if(clientDto.getCart() != null){
//            return cartMapper.cartToDto(clientDto.getCart());
//        } else {
//
//            return getCartDto(clientId);
//        }
    }

    public BigDecimal pricePerCartItemCalculator(BigDecimal price, int amount){
        return price.multiply(BigDecimal.valueOf(amount));
    }

    public List<CartItemDto> cartDetailsByClient(long clientId) throws RuntimeException{
        Cart cart = productService.findOrCreateCart(clientId);
        CartDto cartDto = cartMapper.cartToDto(cart);
        List<CartItem> cartItems = cartDto.getCartItemList();
        if(cartItems.isEmpty()){
            throw new CartIsEmptyException("Cart is empty");
        } else {
            return getCartItemsListDto(cartItems);
        }
    }

    public List<CartItemDto> getCartItemsListDto(List<CartItem> cartItems){
        List<CartItemDto> cartItemsDto = new ArrayList<>();
        for(CartItem cartItem : cartItems){
            CartItemDto cartItemDto = cartItemMapper.entityToDto(cartItem);
            cartItemsDto.add(cartItemDto);
        }
        return cartItemsDto;
    }

    public List<CartItemDto> getCartItemsWithStream(List<CartItem> cartItems){
        return cartItems.stream()
                .map(cartItemMapper::entityToDto)
                .collect(Collectors.toList());
    }


}
