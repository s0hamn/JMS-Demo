package com.example.demo.services;

import com.example.demo.model.Order;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    JmsTemplate jmsTemplate;


    public void placeOrder(Order order) {
        jmsTemplate.send("order-queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(order);
            }
            });
    }
}
