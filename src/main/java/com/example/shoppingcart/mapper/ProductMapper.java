package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.Client2Dto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper {
    private final ProductRepository productRepository;

    public ProductMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Client2Dto clientToDto(Optional<Client> client){
        Client2Dto clientDto = new Client2Dto();
        clientDto.setClientId(client.get().getClientId());
        clientDto.setCart(client.get().getCart());
        clientDto.setAdresses(client.get().getAdresses());
        clientDto.setPhone(client.get().getPhone());
        clientDto.setEmail(client.get().getEmail());
        clientDto.setWallets(client.get().getWallets());
        //clientDto.setFavorite(client.get().getFavorite());
        clientDto.setFirstName(client.get().getFirstName());
        clientDto.setLastName(client.get().getLastName());
        return clientDto;
    }

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
