package com.storeapp.store.services;

import com.storeapp.store.models.Order;
import com.storeapp.store.models.OrderDTO;
import com.storeapp.store.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    OrderRepository orderRep;

    public List<OrderDTO> getAllOrders(){
        var list = orderRep.findAll();
        var dtoList = new ArrayList<OrderDTO>();
        if(list.size()>0) {
            for (Order order : list) {
                dtoList.add(modelMapper.map(order, OrderDTO.class));
            }
        }
        return dtoList;
    }
}
