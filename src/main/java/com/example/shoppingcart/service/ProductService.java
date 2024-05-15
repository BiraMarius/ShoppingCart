package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.CartDto;
import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Product;

import com.example.shoppingcart.exceptions.ProductNotFoundException;

import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public void addToCart(ProductDto productDto, int amount, long clientId){
        CartDto cartDto = cartService.findCart(clientId);
        CartItemDto cartItemDto = productMapper.productToCartItemDtoForCart(productDto, amount, clientId);
        cartItemDto.setShoppingCartId(cartDto.getCartId());
    }

    public void addToCartWithProductid(long productId, int amount, long clientId){
        CartDto cartDto = cartService.findCart(clientId);
    }


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
