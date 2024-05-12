package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper {
    private final ProductRepository productRepository;

    public ProductMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //                NOT USED !!!!
//    public ProductDto entityToDto(Product product){
//        ProductDto productDto = new ProductDto();
//        productDto.setProductId(product.getProductId());
//        productDto.setName(product.getName());
//        productDto.setBrand(product.getBrand());
//        productDto.setDescription(product.getDescription());
//        productDto.setPrice(product.getPrice());
//        productDto.setSmallDescription(productDto.getSmallDescription());
//        return productDto;
//    }

//    public Product productDtoToEntity(CartItemDto cartItemDto){
//        Product product = new Product();
//        product.setProductId(cartItemDto.getProductId());
//        product.setName(cartItemDto.getName());
//        product.setBrand(cartItemDto.getBrand());
//        product.setSmallDescription(cartItemDto.getSmallDescription());
//        product.setPrice(cartItemDto.getPricePerItem());
//        product.setDescription(cartItemDto.getDescription());
//        return product;
//    }
//
//    public CartItem cartItemToEntity(Product product){
//        CartItem cartItem = new CartItem();
//        //cartItem.setProduct(product);
//        cartItem.setName(product.getName());
//        cartItem.setBrand(product.getBrand());
//        cartItem.setSmallDescription(product.getSmallDescription());
//        cartItem.setTotalPerItemType(product.getPrice());
//        return cartItem;
//    }
//
//    public CartItemDto cartItemToDto(CartItem cartItem){
//        CartItemDto cartItemDto = new CartItemDto();
//        //cartItemDto.setProductId(cartItem.getProduct().getProductId());
//        cartItemDto.setBrand(cartItem.getBrand());
//        cartItemDto.setName(cartItem.getName());
//        cartItemDto.setSmallDescription(cartItem.getSmallDescription());
//        return cartItemDto;
//    }

    public CartItemDto cartItemDtoFromProductDto(ProductDto productDto){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(productDto.getProductId());

    }

    public void addToCart(ProductDto productDto){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(productDto.getProductId());

    }

    public CartDto createCart(){
        CartDto cartDto = new CartDto();
        //exista un cart deja?
        // nu exista ?
    }

    //Omul adauga in cart ProductDto printr-o functie ce il transforma in CartItem

    public ProductDto getProductDetails(long productId){
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()){
            return getProductFromOptional(productOpt);
        } else return null; // TODO> FIX RETURN NULL
    }

    private ProductDto getProductFromOptional(Optional<Product> productOpt){
        ProductDto productDto = new ProductDto();
        productDto.setName(productOpt.get().getName());
        productDto.setBrand(productOpt.get().getBrand());
        productDto.setDescription(productOpt.get().getDescription());
        productDto.setSmallDescription(productOpt.get().getSmallDescription());
        productDto.setPrice(productOpt.get().getPrice());
        productDto.setStock(productOpt.get().getStock());
        return productDto;
    }
}
