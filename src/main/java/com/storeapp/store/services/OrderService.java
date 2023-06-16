package com.storeapp.store.services;

import com.storeapp.store.models.Order;
import com.storeapp.store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRep;
    public List<Order> getAllOrders(){
        return orderRep.findAll();
    }
}
