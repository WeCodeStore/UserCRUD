package com.storeapp.store.controllers;

import com.storeapp.store.models.*;
import com.storeapp.store.utils.TypeReferenceMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
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
    void getAllReviewsTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/reviews").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var reviewDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ReviewDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(reviewDTOList.isEmpty());
        assertEquals("/store/reviews", requestUri);
        assertThat(reviewDTOList.get(0)).isInstanceOf(ReviewDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("Working Product", reviewDTOList.get(0).getComment());
        assertEquals(2, reviewDTOList.size());
    }

    @Test
    void getAllReviewsByProductTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/reviews/product/1").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var reviewDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ReviewDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(reviewDTOList.isEmpty());
        assertEquals("/store/reviews/product/1", requestUri);
        assertThat(reviewDTOList.get(0)).isInstanceOf(ReviewDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("Working Product", reviewDTOList.get(0).getComment());
        assertEquals(2, reviewDTOList.size());
    }

    @Test
    void getAllReviewsByUserTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/reviews/user/1").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var reviewDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, ReviewDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(reviewDTOList.isEmpty());
        assertEquals("/store/reviews/user/1", requestUri);
        assertThat(reviewDTOList.get(0)).isInstanceOf(ReviewDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("Working Product", reviewDTOList.get(0).getComment());
        assertEquals(1, reviewDTOList.size());
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
    void getPaginatedProductSuccessTest() throws Exception {

        var requestBuilder = MockMvcRequestBuilders.get("/store/products/page").param("pageNumber","0").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
       // var productPageDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, PageOfProductsDTO<List<ProductDTO>>.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
    }

    @Test
    void getPaginatedProductByCategorySuccessTest() throws Exception {

        var requestBuilder = MockMvcRequestBuilders.get("/store/products/category/page").param("categoryId","4").param("pageNumber","0").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        // var productPageDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, PageOfProductsDTO<List<ProductDTO>>.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
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

    @Test
    void getAllRolesTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/roles").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var roleDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, RoleDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(roleDTOList.isEmpty());
        assertEquals("/store/roles", requestUri);
        assertThat(roleDTOList.get(0)).isInstanceOf(RoleDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("admin", roleDTOList.get(0).getName());
        assertEquals(3, roleDTOList.size());
    }

    @Test
    void getAllUsersTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/users").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var adminUserDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, AdminUserDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(adminUserDTOList.isEmpty());
        assertEquals("/store/users", requestUri);
        assertThat(adminUserDTOList.get(0)).isInstanceOf(AdminUserDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("John", adminUserDTOList.get(0).getFirstName());
        assertEquals(8, adminUserDTOList.size());
    }

    @Test
    void getUserById() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/users/1").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var adminUserDTO = TypeReferenceMapper.deserializeJsonStringToObject(resultString, AdminUserDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertEquals("/store/users/1", requestUri);
        assertThat(adminUserDTO).isInstanceOf(AdminUserDTO.class);
        assertEquals("John",adminUserDTO.getFirstName());
    }


    @Test
    void getAllCategoryTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/categories").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var categoryDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, CategoryDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(categoryDTOList.isEmpty());
        assertEquals("/store/categories", requestUri);
        assertThat(categoryDTOList.get(0)).isInstanceOf(CategoryDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("Outdoor",categoryDTOList.get(0).getName());
        assertEquals(6, categoryDTOList.size());
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
        assertEquals("tree", imageDTOList.get(0).getName());
        assertEquals(5, imageDTOList.size());
    }

  // @Test
//    void postImageTest() throws Exception {
//        MockMultipartFile  uploadFile = new MockMultipartFile("image", "brush.jpg", "image/jpg", new byte[1]);
//        var result = mockMvc.perform(MockMvcRequestBuilders.multipart("/store/image/upload/file")
//                       .file("image", uploadFile.getBytes())
//                       .param("productId", "1")
//                       .characterEncoding("UTF-8"))
//                       .andExpect(status().isOk()).andReturn();
//
//        assertEquals("Image uploaded successfully: ", result.getResponse().getContentAsString());
//    }

    @Test
    void getImageInfoByNameTest() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/image/info/tree").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var imageDTO = TypeReferenceMapper.deserializeJsonStringToObject(resultString, ImageDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertEquals("/store/image/info/tree", requestUri);
        assertThat(imageDTO).isInstanceOf(ImageDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals("tree", imageDTO.getName());
    }

    @Test
    void getImagesInfoByNameTestInvalidName() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/image/info/").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isNotFound()).andReturn();
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
        assertEquals("tree", imageDTOList.get(0).getName());
        assertEquals(4, imageDTOList.size());
    }

    @Test
    void getImagesByProductIdTestInvalidId() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/store/image/byproduct/-1").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isBadRequest()).andReturn();
        assertNotNull(result);
        var requestUri = result.getRequest().getRequestURI();
        assertEquals("/store/image/byproduct/-1", requestUri);
        assertEquals("The image product id must be positive number.", result.getResponse().getHeader("error").toString());
    }

   // @Test
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

    @Test
    void getAllOrdersTest() throws Exception{
        var requestBuilder = MockMvcRequestBuilders.get("/store/orders").accept(MediaType.APPLICATION_JSON);
        var result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        var resultString = result.getResponse().getContentAsString();
        var orderDTOList = TypeReferenceMapper.deserializeJsonStringToList(resultString, OrderDTO.class);
        var requestUri = result.getRequest().getRequestURI();

        assertNotNull(result);
        assertFalse(orderDTOList.isEmpty());
        assertEquals("/store/orders", requestUri);
        assertThat(orderDTOList.get(0)).isInstanceOf(OrderDTO.class);
        // checking for actual values may not be efficient when DB changes
        assertEquals(578446, orderDTOList.get(0).getOrderNumber());
        assertEquals(1, orderDTOList.size());
    }
}
