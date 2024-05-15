package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.ClientDto;
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
    public ClientDto findClientDto(long clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()){
            return productMapper.clientToDto(client);
        }else return null;// TODO> FIX RETURN NULL
    }

    //FOR TESTING
    public void clientsAvailable(){
        Client client1 = new Client();
        client1.setFirstName("Gigi");
        client1.setLastName("Nedelcu");

        Client client2 = new Client();
        client2.setFirstName("Aurel");
        client2.setLastName("Zurlea");

        Client client3 = new Client();
        client3.setFirstName("Andrei");
        client3.setLastName("Tamas");

        Client client4 = new Client();
        client4.setFirstName("Victor");
        client4.setLastName("Sorescu");

        Client client5 = new Client();
        client5.setFirstName("Marius");
        client5.setLastName("Monnet");

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        clientRepository.save(client4);
        clientRepository.save(client5);

    }


}
