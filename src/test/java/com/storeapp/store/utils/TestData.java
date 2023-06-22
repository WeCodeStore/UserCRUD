package com.storeapp.store.utils;

import com.storeapp.store.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestData {

    public static List<Role> roleList = new ArrayList<Role>();
    public static User user = new User(roleList,1L, "John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798");
    public static AdminUserDTO adminUserDTO = new AdminUserDTO(1L,"John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798", null);
    public static Address address = new Address(1L, "Charlotte", "123 New Street", "NC", "28092", "USA", user, user);
    public static List<Address> addressList = new ArrayList<>(Collections.singletonList(address));
    public static AddressDTO addressDto = new AddressDTO(1L, "Charlotte", "123 New Street", "NC", "28092", "USA");
    public static List<AddressDTO> addressDtoList = new ArrayList<>(Collections.singletonList(addressDto));
    public static Product product = new Product();
    public static List<Product> productList = new ArrayList<>(Collections.singletonList(product));
    public static Category category = new Category(1L, "Electronics", productList );
    public static List<Category> categoryList = new ArrayList<>(Collections.singletonList(category));
    public static Image image = new Image(1l, "tree", "png", null, "http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png", product);
    public static List<Image> images = new ArrayList<>(Collections.singletonList(image));
    public static ImageDTO imageDTO = new ImageDTO(1l, "tree", "png", null, "http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png");
    public static List<ImageDTO> imageDTOList = new ArrayList<>(Collections.singletonList(imageDTO));
    public static List<ImageDTO> imageDTOEmpty  = new ArrayList<ImageDTO>();
}
