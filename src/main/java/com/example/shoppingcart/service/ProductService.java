package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.*;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Client;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.exceptions.ClientNotFoundException;
import com.example.shoppingcart.mapper.CartItemMapper;
import com.example.shoppingcart.mapper.CartMapper;
import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.ClientRepository;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.specification.ProductSpecification;
import com.example.shoppingcart.specification.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final CartMapper cartMapper;
    private final CartRepository cartRepository;
    private final ClientRepository clientRepository;
    private final CartItemMapper cartItemMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

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

    public void addProductsToDb(List<ProductDto> products){
        for(ProductDto productDto : products){
            productRepository.save(productMapper.productFromDto(productDto));
        }
    }

    public List<ProductDto> mapperForProductList(List<Product> products){
        return products.stream()
                .map(productDto -> productMapper.entityToDto(productDto))
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductByCriteria(SearchCriteria criteria){
        ProductSpecification spec = new ProductSpecification(criteria);
        List<Product> products = productRepository.findAll(spec);
        return mapperForProductList(products);
    }

    public List<ProductDto> getAvailableProductsInStock(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .filter(product -> product.getStock()>0)
                .map(productDto -> productMapper.entityToDto(productDto))
                .collect(Collectors.toList());
    }


}


