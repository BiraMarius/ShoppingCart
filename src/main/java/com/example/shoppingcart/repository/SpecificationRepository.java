package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification,Long> {

}
