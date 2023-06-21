package com.storeapp.store.controllers;

import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.models.Role;
import com.storeapp.store.models.User;
import com.storeapp.store.services.AddressService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressControllerTest {

    @Mock
    private AddressService addressService;

    @InjectMocks
    AddressController addressController;

    public static List<Role> list = new ArrayList<Role>();
    public static User user = new User(list,1L, "John", "Smith", "jsmith", "jsmith@email.com", null, null, "123456798");
    public static AddressDTO address = new AddressDTO(1L, "Charlotte", "123 New Street", "NC", "28092", "USA");
    public static List<AddressDTO> addressList = new ArrayList<AddressDTO>();

    @BeforeAll
    public static void init() {
        addressList.add(address);
    }

    @Test
    void getAllAddressesTest() {
        var expected = addressList;
        Mockito.when(addressService.getAllAddresses()).thenReturn(expected);
        var actual = addressController.getAllAddresses();
        assertEquals(expected.get(0).getCity(), actual.get(0).getCity());
    }

    @Test
    void getAllAddressesTestReturnsNull() {
        Mockito.when(addressService.getAllAddresses()).thenReturn(null);
        var actual = addressController.getAllAddresses();
        assertNull(actual);
    }
}