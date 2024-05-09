package com.example.shoppingcart;

import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Category;
import com.example.shoppingcart.entity.Product;

import com.example.shoppingcart.repository.CategoryRepository;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
public class CartController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ShoppingCartService shoppingCartService;
//
//    private final ProductMapper productMapper;
//
//    private final ShoppingCartRepository shoppingCartRepository;

    public CartController(ProductRepository productRepository, CategoryRepository categoryRepository, ShoppingCartService shoppingCartService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.shoppingCartService = shoppingCartService;
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

    @GetMapping("/findAll")
    public void findAll() {
        System.out.println("inainte");
        Product product = new Product();
        //INSERT INTO PRODUCT(NAME, BRAND, DESCRIPTION, PRICE,STOCK,SMALL_DESCRIPTION) VALUES('Telefon','Samsung','Nou','1000','1','ss');
        product.setName("Samsung");
        product.setBrand("SAM CO");
        product.setDescription("NOUUU");
        product.setPrice(BigDecimal.valueOf(1000));
        product.setStock(2);
        product.setSmallDescription("vechi");

        Product product2 = new Product();
        product2.setName("Apple");
        product2.setBrand("SAM CO");
        product2.setDescription("sssss");
        product2.setPrice(BigDecimal.valueOf(1000));
        product2.setStock(2);
        product2.setSmallDescription("vechi");


        Category category = new Category();
        category.setName("telefon");
        category.setProducts(Arrays.asList(product, product2));


        productRepository.save(product);

        categoryRepository.save(category);

        categoryRepository.findAll();

        System.out.println("dupa");
    }


}
