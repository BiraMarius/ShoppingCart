package com.example.shoppingcart.mapper;

import com.example.shoppingcart.dto.SpecificationDto;
import com.example.shoppingcart.entity.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationMapper {

    public SpecificationDto specificationToDto(Specification specification){
        return SpecificationDto.builder()
                .idDto(specification.getSpecificationId())
                .nameDto(specification.getSpecificationName())
                .valueDto(specification.getSpecificationValue())
                .build();
    }

    public Specification dtoToSpecification(SpecificationDto specificationDto){
        return Specification.builder()
                .specificationName(specificationDto.getNameDto())
                .specificationValue(specificationDto.getValueDto())
                .build();
    }
}
