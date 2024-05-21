package com.example.shoppingcart;

import com.example.shoppingcart.dto.ClientDto;
import com.example.shoppingcart.entity.Client;
import com.example.shoppingcart.mapper.ClientMapper;
import com.example.shoppingcart.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClientController {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientController(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @PostMapping("/add-client")
    public String add(@RequestBody ClientDto clientDto){
        Client client = clientRepository.save(clientMapper.dtoToEntity(clientDto));
//        return clientMapper.clientToDto(client);
        return "Client inserted with ID: "+client.getClientId();
    }
}
