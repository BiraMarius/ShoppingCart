package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.CartDto;
import com.example.shoppingcart.dto.CartItemDto;
import com.example.shoppingcart.dto.ClientDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.CartItem;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.ClientRepository;
import com.example.shoppingcart.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ProductMapper {
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    public ProductMapper(ProductRepository productRepository, ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    public CartItemDto productToCartItemDtoForCart(ProductDto productDto, int amount, long clientId){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(productDto.getProductId());
        cartItemDto.setName(productDto.getName());
        cartItemDto.setBrand(productDto.getBrand());
        cartItemDto.setSmallDescription(productDto.getSmallDescription());
        cartItemDto.setDescription(productDto.getDescription());
        cartItemDto.setTotalPerItemType(pricePerCartItemCalculator(productDto.getPrice(), amount));
        cartItemDto.setPricePerItem(productDto.getPrice());
        cartItemDto.setAmount(amount);
        return cartItemDto;
    }

    public BigDecimal pricePerCartItemCalculator(BigDecimal price, int amount){
        BigDecimal total = price.multiply(BigDecimal.valueOf(amount));
        return total;
    }

    public CartDto cartToDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setTotal(cart.getTotal());
        cartDto.setCartItemList(cart.getCartItemList());
        cartDto.setOrder(cart.getOrder());
        cartDto.setClient(cart.getClient());
        return  cartDto;
    }



    public ClientDto clientToDto(Optional<Client> client){
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(client.get().getClientId());
        clientDto.setCart(client.get().getCart());
        clientDto.setAdresses(client.get().getAdresses());
        clientDto.setPhone(client.get().getPhone());
        clientDto.setEmail(client.get().getEmail());
        clientDto.setWallets(client.get().getWallets());
        clientDto.setFavorite(client.get().getFavorite());
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
