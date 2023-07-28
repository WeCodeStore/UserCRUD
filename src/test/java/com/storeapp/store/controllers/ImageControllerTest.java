package com.storeapp.store.controllers;

import com.storeapp.store.services.ImageService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ImageControllerTest {
    @Mock
    private ImageService imageService;

    @InjectMocks
    ImageController imageController;


    @Test
    void postImageTest() {
        MockMultipartFile uploadFile = new MockMultipartFile("image", "brush.jpg", "image/jpg", new byte[1]);
        var expected = TestData.imageDTOList;
        try {
            Mockito.when(imageService.uploadImage(uploadFile, 1l)).thenReturn("Image uploaded successfully: brush.jpg");
            var actual = imageController.uploadImage(uploadFile, 1l);
            assertEquals("Image uploaded successfully: brush.jpg", actual.getBody().toString());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void getAllImageTest() {
        var expected = TestData.imageDTOList;
        Mockito.when(imageService.getAllImages()).thenReturn(expected);
        var actual = imageController.getAllImages();
        assertEquals(expected.get(0).getName(), actual.getBody().get(0).getName());
    }

    @Test
    void getAllImageTestReturnsNull() {
        Mockito.when(imageService.getAllImages()).thenReturn(TestData.imageDTOEmpty);
        var actual = imageController.getAllImages();
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());

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
    void getImagesByProductTestInvalidImageName() {
        var actual = imageController.getImagesByProduct(-1l);

        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
        assertEquals("The image product id must be positive number.", actual.getHeaders().getFirst("Error"));
    }

    @Test
    void getImageInfoByNameTest() {
        var expected = TestData.imageDTOList;

        Mockito.when(imageService.getInfoByImageByName("tree")).thenReturn(expected);
        var actual = imageController.getImageInfoByName("tree");
        assertEquals(expected.get(0).getName(), Objects.requireNonNull(actual.getBody()).get(0).getName());
    }

    @Test
    void getImageInfoByNameTestReturnsNull() {
        Mockito.when(imageService.getInfoByImageByName("tree")).thenReturn(null);
        var actual = imageController.getImageInfoByName("tree");
        assertNull(actual.getBody());
    }

    @Test
    void getImageInfoByNameTestInvalidImageName() {
        var actual = imageController.getImageInfoByName("");

        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
        assertEquals("The image name must not be empty string.", actual.getHeaders().getFirst("Error"));
    }
}
