package com.example.demo.repositories;

import com.example.demo.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductDetails, Integer>{
}
