package com.example.demo.services;


import com.example.demo.model.Order;
import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {


    @JmsListener(destination = "order-queue")
    public void receiveOrder(Message message) {
        try {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Order order = (Order) objectMessage.getObject();
                System.out.println("Order received: " + order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
