package com.storeapp.store.controllers;

import com.storeapp.store.models.Order;
import com.storeapp.store.models.OrderDTO;
import com.storeapp.store.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("")
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

}
