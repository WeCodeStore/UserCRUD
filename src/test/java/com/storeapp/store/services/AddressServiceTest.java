package com.storeapp.store.services;

import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.repository.AddressRepository;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressServiceTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressService addressService;

    @Test
    void getAllAddressesTest() {
        Mockito.when(addressRepository.findAll()).thenReturn(TestData.addressList);
        var actual = addressService.getAllAddresses();
        assertEquals("Charlotte", actual.get(0).getCity());
        assertThat(actual.get(0)).isInstanceOf(AddressDTO.class);
    }

    @Test
    void getAllAddressesTestReturnsEmptyList() {
        Mockito.when(addressRepository.findAll()).thenReturn(new ArrayList<>());
        var actual = addressService.getAllAddresses();
        assertEquals(0, actual.size());
    }
}
