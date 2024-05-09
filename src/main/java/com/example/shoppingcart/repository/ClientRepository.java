package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
