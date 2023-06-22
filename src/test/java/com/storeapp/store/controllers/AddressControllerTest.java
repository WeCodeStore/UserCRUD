package com.storeapp.store.controllers;

import com.storeapp.store.services.AddressService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressControllerTest {

    @Mock
    private AddressService addressService;

    @InjectMocks
    AddressController addressController;

    @Test
    void getAllAddressesTest() {
        var expected = TestData.addressDtoList;
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