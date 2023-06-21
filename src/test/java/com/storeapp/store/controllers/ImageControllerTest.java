package com.storeapp.store.controllers;

import com.storeapp.store.services.AddressService;
import com.storeapp.store.services.ImageService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ImageControllerTest {
    @Mock
    private ImageService imageService;

    @InjectMocks
    ImageController imageController;

    @Test
    void getAllImageTest() {
        var expected = TestData.imageDTOList;
        Mockito.when(imageService.getAllImages()).thenReturn(expected);
        var actual = imageController.getAllImages();
        assertEquals(expected.get(0).getName(), actual.getBody().get(0).getName());
    }

    @Test
    void getAllImageTestReturnsNull() {
        Mockito.when(imageService.getAllImages()).thenReturn(null);
        var actual = imageController.getAllImages();
        assertNull(actual.getBody());
    }

    @Test
    void getImagesByProductTest() {
        var expected = TestData.imageDTOList;

        Mockito.when(imageService.getImageByProductId(1l)).thenReturn(expected);
        var actual = imageController.getImagesByProduct(1l);
        assertEquals(expected.get(0).getName(), actual.getBody().get(0).getName());
    }

    @Test
    void getImagesByProductTestReturnsNull() {
        Mockito.when(imageService.getImageByProductId(0l)).thenReturn(null);
        var actual = imageController.getImagesByProduct(0l);
        assertNull(actual.getBody());
    }

    @Test
    void getImageInfoByNameTest() {
        var expected = TestData.imageDTO;

        Mockito.when(imageService.getInfoByImageByName("tree")).thenReturn(expected);
        var actual = imageController.getImageInfoByName("tree");
        assertEquals(expected.getName(), actual.getBody().getName());
    }

    @Test
    void getImageInfoByNameTestReturnsNull() {
        Mockito.when(imageService.getImageByProductId(0l)).thenReturn(null);
        var actual = imageController.getImagesByProduct(0l);
        assertNull(actual.getBody());
    }
}
