package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.Client2Dto;
import com.example.shoppingcart.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client dtoToEntity(Client2Dto clientDto){
        return Client.builder()
                .clientId(clientDto.getClientId())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .phone(clientDto.getPhone())
                .email(clientDto.getEmail())
                //.adresses(clientDto.getAdresses())
                //.wallets(clientDto.getWallets())
                //.cart(clientDto.getCart())
//                .favorite(clientDto.getFavorite())
                .build();
    }

    public Client2Dto clientToDto(Client client){
        return Client2Dto.builder()
                .clientId(client.getClientId())
                .cart(client.getCart())
                .phone(client.getPhone())
                .email(client.getEmail())
                .lastName(client.getLastName())
                .firstName(client.getFirstName())
                .wallets(client.getWallets())
                .adresses(client.getAdresses())
                .cart(client.getCart())
                .build();
    }
}
