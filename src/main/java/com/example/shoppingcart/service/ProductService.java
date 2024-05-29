package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.*;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Client;

import com.example.shoppingcart.exceptions.ClientNotFoundException;
import com.example.shoppingcart.mapper.CartItemMapper;
import com.example.shoppingcart.mapper.CartMapper;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final CartMapper cartMapper;
    private final CartRepository cartRepository;
    private final ClientRepository clientRepository;
    private final CartItemMapper cartItemMapper;

    public void addInCart(ItemDto itemDto){
        CartDto cartDto = cartMapper.cartToDto(
                findCart(itemDto.getClientId())
        );
        Cart cart = cartMapper.dtoToEntity(cartDto);
        //Client client = clientService.optionalToClient(itemDto.getClientId());
        //client.setCart(cart);
        cart.addCartItem(cartItemMapper.cartItemFromItemDto(itemDto));
        //clientService.updateClientCart(clientService.optionalToClient(itemDto.getClientId()), cart);
        cartRepository.save(cart);
    }

    public Cart findCart(long clientId) throws RuntimeException{
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            Client client = clientOpt.get();
            if(client.getCart() != null){
                return client.getCart();
            } else {
                Cart cart = new Cart();
                //cart.setClient(client);
                return cartRepository.save(cart);
            }
        } else {
            throw new ClientNotFoundException("Client not found!");
        }
    }

    public void addInCart2(ItemDto itemDto){
        Cart cart = findOrCreateCart(itemDto.getClientId());
        cart.addCartItem(cartItemMapper.cartItemFromItemDto(itemDto));
        cartRepository.save(cart);
    }

    public Cart findOrCreateCart(long clientId) throws RuntimeException{
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            Client client = clientOpt.get();
            Cart cart = client.getCart();
            if(cart == null){
                cart = new Cart();
                cart.setClient(client);
                cart= cartRepository.save(cart);
                client.setCart(cart);
                clientRepository.save(client);
                //clientRepository.saveAndFlush(client);
            }
            return cart;
        } else {
            throw new ClientNotFoundException("Client not found!");
        }
    }


}

//    public void addToCart(ItemDto itemDto){
//        CartDto cartDto = cartService.findCart(itemDto.getClientId());
//        CartItemDto cartItemDto = cartMapper.productToCartItemDtoForCart(itemDto.getProductDto());
//        cartItemDto.setTotalPerItemType(cartService.pricePerCartItemCalculator(itemDto.getProductDto().getPrice(), itemDto.getAmount()));
//        cartItemDto.setAmount(itemDto.getAmount());
//        cartItemDto.setShoppingCartId(cartDto.getCartId());
//        clientRepository.save(clientMapper.findClient(itemDto.getClientId()));
//        cartRepository.save(cartMapper.dtoToEntity(cartDto));
//    }

//    private Product findProductById(long id){
//        Optional<Product> product = productRepository.findById(id);
//        if(product.isPresent()){
//            return product.get();
//        } else {
//            throw new ProductNotFoundException("Product not found!");
//        }
//    }


