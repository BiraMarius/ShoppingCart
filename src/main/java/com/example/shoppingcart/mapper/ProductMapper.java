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

import java.util.Optional;

@Component
public class ProductMapper {
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    public ProductMapper(ProductRepository productRepository, ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
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

    public void addToCart(ProductDto productDto, long clientId){
        CartDto cartDto = findCart(clientId);
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(productDto.getProductId());

    }

    public CartDto createOrReturnCart(CartItemDto cartItemDto, long clientId){
        CartDto cartDto = findCart(clientId);

    }

    //Omul adauga in cart ProductDto printr-o functie ce il transforma in CartItem

    public CartDto findCart(long clientId){
        ClientDto clientDto = findClientDto(clientId);
        if(clientDto.getCart() != null){
            return cartToDto(clientDto.getCart());
        } else return new CartDto();
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

    public ClientDto findClientDto(long clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()){
            return clientToDto(client);
        }else return null;// TODO> FIX RETURN NULL
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
