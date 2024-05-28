package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.CartDto;
import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Client;
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

@Service
@AllArgsConstructor
public class CartService {

    private final ProductMapper productMapper;
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final CartRepository CartRepository;
    private final CartMapper cartMapper;
    private final CartItemMapper cartItemMapper;

    public Cart findCart(long clientId){
        //ClientDto clientDto = clientService.findClientDto(clientId);
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

//    private CartDto getCartDto(long clientId) {
//        Optional<Client> clientOpt = clientRepository.findById(clientId);
//        if(clientOpt.isPresent()){
//            Client client = clientOpt.get();
//            client.setCart(cartMapper.dtoToEntity(cartDto));
//        }
//        //clientOpt.ifPresent(cartDto::setClient);
//        return cartDto;
//    }

    public BigDecimal pricePerCartItemCalculator(BigDecimal price, int amount){
        return price.multiply(BigDecimal.valueOf(amount));
    }

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

    public List<CartItemDto> cartDetails(long clientId){
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if(optionalClient.isPresent()){
            Optional<Cart> optionalCart = CartRepository.findById(optionalClient.get().getClientId());
            if(optionalCart.isPresent()){
                Cart cart = optionalCart.get();
                CartDto cartDto = cartMapper.cartToDto(cart);
                return getCartItemsListDto(cartDto.getCartItemList());
            } else {
                return "Cart is empty";
            }
        } else {
            return "Client not found";
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
        CartRepository.save(cart);
    }


    public List<CartItem> cartDetailsByCart(long cartId){
        Cart cart =
    }

    public List<CartItem> cartDetailsByClient(long clientId){
        Client client =
    }
}
