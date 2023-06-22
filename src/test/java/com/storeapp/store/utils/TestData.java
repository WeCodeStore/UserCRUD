package com.storeapp.store.utils;

import com.storeapp.store.models.*;

import java.util.*;

public class TestData {

    public static Role role = new Role(1L, "admin", new ArrayList<>());
    public static RoleDTO roleDTO = new RoleDTO(1L, "admin", new ArrayList<>());
    public static List<Role> roleList = new ArrayList<Role>(List.of(role));

    public static List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>(List.of(roleDTO));

    public static User user = new User(roleList,1L, "John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798");

    public static Address address = new Address(1L, "Charlotte", "123 New Street", "NC", "28092", "USA", user, user);
    public static List<Address> addressList = new ArrayList<>(Collections.singletonList(address));
    public static AddressDTO addressDto = new AddressDTO(1L, "Charlotte", "123 New Street", "NC", "28092", "USA");
    public static List<AddressDTO> addressDtoList = new ArrayList<>(Collections.singletonList(addressDto));
}
