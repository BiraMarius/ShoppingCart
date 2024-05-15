package com.example.shoppingcart;

import com.example.shoppingcart.dto.ItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Category;
import com.example.shoppingcart.entity.Product;

import com.example.shoppingcart.repository.CategoryRepository;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.service.ProductService;
import com.example.shoppingcart.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
public class CartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;


    public CartController(ShoppingCartService shoppingCartService, ProductService productService) {

        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

//    public Controller(ProductRepository productRepository, ShoppingCartService shoppingCartService, ProductMapper productMapper, ShoppingCartRepository shoppingCartRepository) {
//        this.productRepository = productRepository;
//        this.shoppingCartService = shoppingCartService;
//        this.productMapper = productMapper;
//        this.shoppingCartRepository = shoppingCartRepository;
//    }
//
//    @GetMapping("/productListing")
//    public List<Product> productListing(){
//        return productRepository.findAll();
//    }
//
////    @GetMapping("/productsInStock")
////    public List<Product> productListing(@RequestParam int stock){
////        return productRepository.findAllByStockGreaterThan(stock);
////    }
//
//
//    @GetMapping("/productListingID")
//    public Product productListingByID(@RequestParam long id){
//        Optional<Product> product=productRepository.findById(id);
//        return product.get();
//    }

//    @PostMapping("/add-product-to-cart")
//    public CartItemDto addToCart(@RequestBody CartItemDto cartItemDto){
//        if(cartItemDto.getAmount() <= productMapper.productDtoToEntity(cartItemDto).getStock()){
//            return shoppingCartService.addToCartItemDto(cartItemDto.getShoppingCartId(),productMapper.productDtoToEntity(cartItemDto));
//        } else return null;
//    }

//    @GetMapping("/show-products-in-cart")
//    public List<CartItem> showproductsInCart(@RequestParam long clientId) {
//
//        return shoppingCartRepository.findByShoppingCartId(cartId).getCartItemList();
//    }

//    @GetMapping("/addAmount")
//    public CartItemDto addAmount(ShoppingCart shoppingCart, CartItemDto cartItemDto){
//        return shoppingCartService.addOneCartItem(shoppingCart.getShoppingCartId(),cartItemDto);
//    }
//
//    @GetMapping("/removeAmount")
//    public CartItemDto removeAmount(ShoppingCart shoppingCart, CartItemDto cartItemDto){
//        return shoppingCartService.removeOneCartItem(shoppingCart.getShoppingCartId(),cartItemDto);
//    }


    @PostMapping("/insert-into-cart")
    public void insertInCart(){
        shoppingCartService.insertIntoCart();
    }



    @PostMapping("/add-to-cart")
    public void addInCart(@RequestBody ItemDto itemDto){
        productService.addToCart(itemDto);
    }







}
