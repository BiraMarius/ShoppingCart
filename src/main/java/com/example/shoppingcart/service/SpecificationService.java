package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.SpecificationDto;
import com.example.shoppingcart.mapper.SpecificationMapper;
import com.example.shoppingcart.repository.SpecificationRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecificationService {
private final SpecificationRepository specificationRepository;
private final SpecificationMapper specificationMapper;

    public SpecificationService(SpecificationRepository specificationRepository, SpecificationMapper specificationMapper) {
        this.specificationRepository = specificationRepository;
        this.specificationMapper = specificationMapper;
    }

    public String addSpecification(SpecificationDto specificationDto){
        specificationRepository.save(specificationMapper.dtoToSpecification(specificationDto));
        return "Specification added. ";
    }



}
