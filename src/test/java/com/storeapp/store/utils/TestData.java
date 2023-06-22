package com.storeapp.store.utils;

import com.storeapp.store.models.*;

import java.util.*;

public class TestData {

    public static Role role = new Role(1L, "admin", new ArrayList<>());
    public static RoleDTO roleDTO = new RoleDTO(1L, "admin", new ArrayList<>());
    public static List<Role> roleList = new ArrayList<Role>(List.of(role));
    public static List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>(List.of(roleDTO));
    public static User user = new User(roleList,1L, "John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798");
    public static AdminUserDTO adminUserDTO = new AdminUserDTO(1L,"John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798", null);
    public static Address address = new Address(1L, "Charlotte", "123 New Street", "NC", "28092", "USA", user, user);
    public static List<Address> addressList = new ArrayList<>(Collections.singletonList(address));
    public static AddressDTO addressDto = new AddressDTO(1L, "Charlotte", "123 New Street", "NC", "28092", "USA");
    public static List<AddressDTO> addressDtoList = new ArrayList<>(Collections.singletonList(addressDto));
    public static Image image = new Image(1l, "tree", "png", null, "http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png", new Product());
    public static List<Image> images = new ArrayList<>(Collections.singletonList(image));
    public static Order order = new Order();
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
