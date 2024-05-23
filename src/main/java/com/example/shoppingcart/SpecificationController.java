package com.example.shoppingcart;

import com.example.shoppingcart.dto.SpecificationDto;
import com.example.shoppingcart.service.SpecificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpecificationController {
    private final SpecificationService specificationService;

    public SpecificationController(SpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @PostMapping("/add-specification-name")
    public String addSpecificationInDb(@RequestBody SpecificationDto specificationDto){
        return specificationService.addSpecification(specificationDto);
    }

}
