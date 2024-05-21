package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.ClientDto;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientMapper {
    private final ClientRepository clientRepository;

    public ClientMapper(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client dtoToEntity(ClientDto clientDto){
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

    public ClientDto clientToDto(Client client){
        return ClientDto.builder()
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

    public Client findClient(long clientId){
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            Client client = clientOpt.get();
            return client;
        } else {
            return null;
        }
    }
}
