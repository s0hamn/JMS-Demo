package com.example.demo.controllers;

import com.example.demo.model.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Order Service";
    }

    @PostMapping("/order")
    public String order(@RequestBody Order order) {
        orderService.placeOrder(order);
        return "Order is placed";
    }
}
