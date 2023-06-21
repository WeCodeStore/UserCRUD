package com.storeapp.store.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.services.AddressService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = AddressController.class)
@ExtendWith(SpringExtension.class)
public class MVCAddressControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    public static AddressDTO address = new AddressDTO(1L, "Charlotte", "123 New Street", "NC", "28092", "USA");
    public static List<AddressDTO> addressList = new ArrayList<AddressDTO>();

    @BeforeAll
    public static void init() {
        addressList.add(address);
    }

    @Test
    void getAllAddressesTest() throws Exception {
        Mockito.when(addressService.getAllAddresses()).thenReturn(addressList);
        var requestBuilder = MockMvcRequestBuilders.get("/store/addresses").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var ow = new ObjectMapper();
        TypeReference<List<AddressDTO>> ref = new TypeReference<>() {};
        var addressDTOList = ow.readValue(resultString, ref);
        assertEquals("Charlotte", addressDTOList.get(0).getCity());
    }
}
