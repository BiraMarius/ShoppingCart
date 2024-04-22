package com.example.shoppingcart;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final ProductRepository productRepository;

    public Controller(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/productListing")
    public List<Product> productListing(){
        return productRepository.findAll();
    }

    @GetMapping("/productListingID")
    public Product productListingByID(@RequestParam long id){
        Optional<Product> product=productRepository.findById(id);
        return product.get();
    }


}
