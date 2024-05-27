package com.example.shoppingcart;

import com.example.shoppingcart.dto.ItemDto;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.service.CartService;
import com.example.shoppingcart.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    private final ProductService productService;
    private final CartService cartService;
    private final ProductRepository productRepository;

    public CartController(ProductService productService, CartService cartService, ProductRepository productRepository) {
        this.productService = productService;
        this.cartService = cartService;
        this.productRepository = productRepository;
    }

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

// Main problem is that i need first to build the database with Product proprties
    @PostMapping("/insert-into-cart")
    public void insertInCart(){
        cartService.insertIntoCart();
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody Product product){
        productRepository.save(product);
    }


//    @PostMapping("/add-to-cart")
//    public void addInCart(@RequestBody ItemDto itemDto){
//        productService.addToCart(itemDto);
//    }

    @PostMapping("/add-in-cart")
    public void addInCart(@RequestBody ItemDto itemDto){
        productService.addInCart(itemDto);
    }







}
