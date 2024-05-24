package com.example.demo.services;

import com.example.demo.entity.ProductDetails;
import com.example.demo.model.Order;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void dispatch(Order order) {
        ProductDetails product = productRepository.findById(order.getId()).orElse(null);

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        product.setQuantity(product.getQuantity() - 1);
        productRepository.save(product);

    }
}
