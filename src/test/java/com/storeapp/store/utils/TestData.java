package com.storeapp.store.utils;

import com.storeapp.store.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestData {

    public static Role role = new Role(1L, "admin", new ArrayList<>());
    public static RoleDTO roleDTO = new RoleDTO(1L, "admin", new ArrayList<>());
    public static List<Role> roleList = new ArrayList<Role>(List.of(role));
    public static List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>(List.of(roleDTO));
    public static User user = new User(roleList,1L, "John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798");
    public static AdminUserDTO adminUserDTO = new AdminUserDTO(1L,"John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798", null);
    public static List<AdminUserDTO> adminUserDTOList = new ArrayList(List.of(adminUserDTO));
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
    public static Image image = new Image(1l, "tree", "png", null, "http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png", new Product());
    public static List<Image> images = new ArrayList<>(Collections.singletonList(image));
    public static List<Order> orders = new ArrayList<>(Collections.singletonList(order));
    public static Product product = new Product(orders, 3L, "Chemical", 12.9, 45, "Z5679", "Pop Music", new Category("Music"), images);
    public static List<Product> productList = new ArrayList<>(Collections.singletonList(product));
    public static ProductDTO productDTO = new ProductDTO(3L, "Chemical", 12.9, 45, "Z5679", "Image", "Pop Music",  "Music");
    public static List<ProductDTO> productDtoList = new ArrayList<>(Collections.singletonList(productDTO));
    public static Category category = new Category(1L, "Electronics", productList );
    public static List<Category> categoryList = new ArrayList<>(Collections.singletonList(category));
    public static ImageDTO imageDTO = new ImageDTO(1l, "tree", "png", null, "http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png");
    public static List<ImageDTO> imageDTOList = new ArrayList<>(Collections.singletonList(imageDTO));
    public static List<ImageDTO> imageDTOEmpty  = new ArrayList<ImageDTO>();
}
