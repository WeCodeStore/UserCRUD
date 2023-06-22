package com.storeapp.store.controllers;

import com.storeapp.store.services.OrderService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderControllerTest {

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderController orderController;

    @Test
    void getAllOrdersTest() {
        Mockito.when(orderService.getAllOrders()).thenReturn(TestData.orderDtoList);
        var actual = orderController.getAllOrders();
        assertEquals(123123L, actual.get(0).getOrderNumber());
    }

    @Test
    void getAllOrdersReturnsEmptyListTest() {
        Mockito.when(orderService.getAllOrders()).thenReturn(new ArrayList<>());
        var actual = orderController.getAllOrders();
        assertEquals(0, actual.size());
    }
}
