package com.storeapp.store.controllers;

import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.models.ImageDTO;
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
    void getAllImagesTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/image/all").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var imageDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ImageDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(imageDTOList.isEmpty());
        assertEquals("/store/image/all", requestUri);
        assertThat(imageDTOList.get(0)).isInstanceOf(ImageDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("brush", imageDTOList.get(0).getName());
        assertEquals(6, imageDTOList.size());
    }

    @Test
    void getImageInfoByNameTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/image/info/brush").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var imageDTO = TypeReferenceMapper.deserializeJsonStringToObject(resultString, ImageDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);

        assertEquals("/store/image/info/brush", requestUri);
        assertThat(imageDTO).isInstanceOf(ImageDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("brush", imageDTO.getName());
    }

    @Test
    void getImagesByProductIdTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/image/byproduct/1").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var imageDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ImageDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(imageDTOList.isEmpty());
        assertEquals("/store/image/byproduct/1", requestUri);
        assertThat(imageDTOList.get(0)).isInstanceOf(ImageDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("brush", imageDTOList.get(0).getName());
        assertEquals(5, imageDTOList.size());
    }

    @Test
    void getImagesByNameTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/image/brush").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var imageDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ImageDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(imageDTOList.isEmpty());
        assertEquals("/store/image/byproduct/1", requestUri);
        assertThat(imageDTOList.get(0)).isInstanceOf(ImageDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("brush", imageDTOList.get(0).getName());
        assertEquals(5, imageDTOList.size());
    }
}
