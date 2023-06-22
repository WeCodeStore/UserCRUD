package com.storeapp.store.utils;

import com.storeapp.store.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestData {

    public static List<Role> roleList = new ArrayList<Role>();
    public static User user = new User(roleList,1L, "John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798");
    public static Address address = new Address(1L, "Charlotte", "123 New Street", "NC", "28092", "USA", user, user);
    public static List<Address> addressList = new ArrayList<>(Collections.singletonList(address));
    public static AddressDTO addressDto = new AddressDTO(1L, "Charlotte", "123 New Street", "NC", "28092", "USA");
    public static List<AddressDTO> addressDtoList = new ArrayList<>(Collections.singletonList(addressDto));
    public static Review review = new Review(1L, "comment", 4.7, 1L, 1L);
    public static List<Review> reviewList = new ArrayList<>(Collections.singletonList(review));
    public static ReviewDTO reviewDto = new ReviewDTO(1, "comment", 4.7, 1L, 1L);
    public static List<ReviewDTO> reviewDtoList = new ArrayList<>(Collections.singletonList(reviewDto));
    public static Order order = new Order(1L, 1L, 123123L, LocalDate.now(), new ArrayList<>(), 10.50);
    public static OrderDTO orderDto = new OrderDTO(1L, 1L, 123123L, LocalDate.now(), new ArrayList<>(), 10.50);
    public static List<Order> orderList = new ArrayList<>(Collections.singletonList(order));
    public static List<OrderDTO> orderDtoList = new ArrayList<>(Collections.singletonList(orderDto));
}
