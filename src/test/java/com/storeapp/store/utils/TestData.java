package com.storeapp.store.utils;

import com.storeapp.store.models.Address;
import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.models.Role;
import com.storeapp.store.models.User;

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
}