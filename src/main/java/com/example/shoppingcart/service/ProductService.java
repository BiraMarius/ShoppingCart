package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.*;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.entity.Product;

import com.example.shoppingcart.mapper.CartItemMapper;
import com.example.shoppingcart.mapper.CartMapper;
import com.example.shoppingcart.mapper.ClientMapper;
import com.example.shoppingcart.repository.CartItemRepository;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.ClientRepository;
import com.example.shoppingcart.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

//    private final ProductRepository productRepository;
//
//    private Product findProductById(long id){
//        Optional<Product> product = productRepository.findById(id);
//        if(product.isPresent()){
//            return product.get();
//        } else {
//            throw new ProductNotFoundException("Product not found!");
//        }
//    }

    private final CartService cartService;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;
    private final CartRepository cartRepository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final CartItemMapper cartItemMapper;
    private final CartItemRepository cartItemRepository;

//    public void addToCart(ItemDto itemDto){
//        CartDto cartDto = cartService.findCart(itemDto.getClientId());
//        CartItemDto cartItemDto = cartMapper.productToCartItemDtoForCart(itemDto.getProductDto());
//        cartItemDto.setTotalPerItemType(cartService.pricePerCartItemCalculator(itemDto.getProductDto().getPrice(), itemDto.getAmount()));
//        cartItemDto.setAmount(itemDto.getAmount());
//        cartItemDto.setShoppingCartId(cartDto.getCartId());
//        clientRepository.save(clientMapper.findClient(itemDto.getClientId()));
//        cartRepository.save(cartMapper.dtoToEntity(cartDto));
//    }

    public void addInCart(ItemDto itemDto){
        Client client = optionalToClient(itemDto.getClientId());
        CartDto cartDto = cartMapper.cartToDto(findCart(itemDto.getClientId()));
        List<CartItem> cartItems = cartDto.getCartItemList();
        CartItem cartItem = cartItemMapper.cartItemFromItemDto(itemDto);
        cartItems.add(cartItem);
        cartItem = cartItemRepository.save(cartItem);
        cartItem.setCart(cartMapper.dtoToEntity(cartDto));
        cartRepository.save(cartMapper.dtoToEntity(cartDto));
        //cartMapper.productDtoToCartItemDto(itemDto, cartDto);
        //CartItemDto cartItemDto = cartMapper
    }

    public Client optionalToClient(long clientId){
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            return clientOpt.get();
        } else {
            return null;
        }
    }

    public Cart findCart(long clientId){
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            if(clientOpt.get().getCart() != null){
                return clientOpt.get().getCart();
            } else {
                Cart cart = new Cart();
                Client client = clientOpt.get();
                List<CartItem> cartItems = new ArrayList<>();
                cart.setCartItemList(cartItems);
                cart = cartRepository.save(cart);
                client.setCart(cart);
                clientRepository.save(client);
                return cart;
            }
        } else {
            return null;
        }
    }


//    public void addToCartWithProductid(long productId, int amount, long clientId){
//        CartDto cartDto = cartService.findCart(clientId); // TODO FINISH THIS METHOD
//    }


    //FOR TESTING
    public void productsAvailable(){
        Product product1 = new Product();
        product1.setName("Iphone 23");
        product1.setBrand("Apple");
        product1.setDescription("Cel mai nou Iphone cu 32GB RAM");
        product1.setSmallDescription("32GB RAM, Oled");
        product1.setPrice(BigDecimal.valueOf(5000));

        Product product2 = new Product();
        product2.setName("S99");
        product2.setBrand("Samsung");
        product2.setDescription("Cel performant televizor cu tehnologia blabla.");
        product2.setSmallDescription("64GB RAM, Oled, blabla");
        product2.setPrice(BigDecimal.valueOf(11000));

        Product product3 = new Product();
        product3.setName("Paracetamol");
        product3.setBrand("DaciaFarm");
        product3.setDescription("Medicamentul potrivit pentru dureri de cap si altele");
        product3.setSmallDescription("Paracetamol cu vitamina X");
        product3.setPrice(BigDecimal.valueOf(15));

        Product product4 = new Product();
        product4.setName("Mar Rosu");
        product4.setBrand("Livada rosie");
        product4.setDescription("Mere Bio crescute in livada din zona 2");
        product4.setSmallDescription("Mar rosu BIO");
        product4.setPrice(BigDecimal.valueOf(2));

        Product product5 = new Product();
        product5.setName("Gin Boe Violet Fantasy");
        product5.setBrand("Boe");
        product5.setDescription("Cel mai aromat gin venit direct din UK");
        product5.setSmallDescription("Boe Violet");
        product5.setPrice(BigDecimal.valueOf(250));

        Product product6 = new Product();
        product6.setName("Prosecco");
        product6.setBrand("MOET");
        product6.setDescription("Prosecco stors si fermentat din struguri virgini din Franta si Italia");
        product6.setSmallDescription("Prosecco France&Italy");
        product6.setPrice(BigDecimal.valueOf(900));

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
    }



}
