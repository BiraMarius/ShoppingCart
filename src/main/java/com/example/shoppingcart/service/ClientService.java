package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.Client2Dto;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.mapper.ProductMapper;
import com.example.shoppingcart.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ProductMapper productMapper;
    public Client2Dto findClientDto(long clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()){
            return productMapper.clientToDto(client);
        }else return null;// TODO> FIX RETURN NULL
    }

}
