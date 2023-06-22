package com.storeapp.store.controllers;

import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.models.ProductDTO;
import com.storeapp.store.utils.TypeReferenceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MvcControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllAddressesTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/addresses").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var addressDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, AddressDTO.class);
//        var address = TypeReferenceMapper.deserializeJsonStringToObject("{\"id\":1,\"city\":\"Charlotte\",\"street\":\"123 Seezam street\",\"state\":\"NC\",\"postalCode\":\"28092\",\"country\":\"USA\"}", AddressDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(addressDTOList.isEmpty());
        assertEquals("/store/addresses", requestUri);
        assertThat(addressDTOList.get(0)).isInstanceOf(AddressDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("Charlotte", addressDTOList.get(0).getCity());
        assertEquals(10, addressDTOList.size());
    }

    @Test
    void getAllProductsTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/products").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var productDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ProductDTO.class);
        var requestUri = result.getRequest().getRequestURI();
        assertNotNull(result);
        assertFalse(productDTOList.isEmpty());
        assertEquals("/store/products", requestUri);
        assertThat(productDTOList.get(0)).isInstanceOf(ProductDTO.class);
        assertEquals("bear", productDTOList.get(0).getName());
        assertEquals(15, productDTOList.size());
    }

    @Test
    void getProductById() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/products/1").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var productDTO = TypeReferenceMapper.deserializeJsonStringToObject(resultString, ProductDTO.class);
        var requestUri = result.getRequest().getRequestURI();
        assertNotNull(result);
        assertEquals("/store/products/1", requestUri);
        assertThat(productDTO).isInstanceOf(ProductDTO.class);
        assertEquals("bear", productDTO.getName());
    }

    @Test
    void getProductsByCategory() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/products/category/4").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var productDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ProductDTO.class);
        var requestUri = result.getRequest().getRequestURI();
        assertNotNull(result);
        assertFalse(productDTOList.isEmpty());
        assertEquals("/store/products/category/4", requestUri);
        assertThat(productDTOList.get(0)).isInstanceOf(ProductDTO.class);
        assertEquals("bear", productDTOList.get(0).getName());
        assertTrue(productDTOList.size() >= 1);
    }
}
