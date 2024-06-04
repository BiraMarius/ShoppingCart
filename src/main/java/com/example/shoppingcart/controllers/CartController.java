package com.example.shoppingcart.controllers;

import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ItemDto;

import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.service.CartService;
import com.example.shoppingcart.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final ProductService productService;
    private final CartService cartService;

    public CartController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @PostMapping("/add-in-cart2")
    public String addInCart2(@RequestBody ItemDto itemDto){
        if(itemDto.getProductDto().getStock()>0){
            if(itemDto.getAmount() <= itemDto.getProductDto().getStock()){
                productService.addInCart2(itemDto);
                return "Product added to the cart.";
            } else {
                return "Amount requested is not available.";
            }
        } else {
            return "Product not in stock";
        }
    }

    @GetMapping("/get-cart-details-by-client")
    public List<CartItemDto> getCartItems(@RequestParam long clientId){
        return cartService.cartDetailsByClient(clientId);
    }

    @PostMapping
    public List<CartItemDto> addAmount(@RequestParam long clientId, @RequestParam long cartItemId){

    }

}
