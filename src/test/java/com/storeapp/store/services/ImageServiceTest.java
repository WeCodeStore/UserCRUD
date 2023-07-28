package com.storeapp.store.services;

import com.storeapp.store.helper.ImageUtil;
import com.storeapp.store.models.Image;
import com.storeapp.store.models.ImageDTO;
import com.storeapp.store.repository.ImageRepository;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImageServiceTest {
    @Mock
    ImageRepository imageRepository;

    @InjectMocks
    ImageService imageService;


    @Test
    void postImageTest() {
        byte[] bytes = {1, 3,0,5};
        MockMultipartFile saveFile = new MockMultipartFile("image", "brush.jpg", "image/jpg", bytes);

        Image saveImage = Image.builder()
                .name(saveFile.getOriginalFilename())
                .type(saveFile.getContentType())
                .imageData(ImageUtil.compressImage(bytes)).build();
        try {
            Mockito.when(imageRepository.save(saveImage)).thenReturn(saveImage);
            var actual = imageService.uploadImage(saveFile, 1l);
            assertEquals("Image uploaded successfully: brush.jpg", actual);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllImageTest() {
        Mockito.when(imageRepository.findAll()).thenReturn(TestData.images);
        var actual = imageService.getAllImages();
        assertEquals("tree", actual.get(0).getName());
        assertThat(actual.get(0)).isInstanceOf(ImageDTO.class);
    }

    @Test
    void getAllImagesTestReturnsEmptyList() {
        Mockito.when(imageRepository.findAll()).thenReturn(new ArrayList<>());
        var actual = imageService.getAllImages();
        assertEquals(0, actual.size());
    }

//    @Test
//    void getInfoByImageByNameTest() {
//        Optional<Image> image = Optional.of(TestData.images.get(0));
//
//        Mockito.when(imageRepository.findByName("tree")).thenReturn(image);
//        var actual = imageService.getInfoByImageByName("tree");
//        assertEquals("tree", actual.getName());
//        assertThat(actual).isInstanceOf(ImageDTO.class);
//    }

    @Test
    void getInfoByImageByNameTestReturnNull() {
        Optional<Image> image = Optional.of(TestData.images.get(0));

        Mockito.when(imageRepository.findByName("apple")).thenReturn(null);
        var actual = imageService.getInfoByImageByName("apple");
        assertNull(actual);
    }

    @Test
    void getInfoByImageByNameTestReturnEmptyImage() {
        Optional<Image> image = Optional.of(TestData.images.get(0));

        Mockito.when(imageRepository.findByName("apple")).thenReturn(null);
        var actual = imageService.getInfoByImageByName("apple");
        assertNull(actual);
    }


    @Test
    void getImageByProductIdTest() {
        Mockito.when(imageRepository.findAllByProductId(1l)).thenReturn(TestData.images);
        var actual = imageService.getImageByProductId(1l);
        assertEquals(1, actual.size() );
        assertEquals("tree", actual.get(0).getName());
        assertThat(actual.get(0)).isInstanceOf(ImageDTO.class);
    }

//    @Test
//    void getImageTest() {
//
//        Image tempImage = new Image(TestData.image.getImageId(), TestData.image.getName(), TestData.image.getType(), TestData.image.getImageData(), TestData.image.getImageUrl(), TestData.image.getProduct());
//        byte[] bytes = {0, 1, 1, 1};
//
//        tempImage.setImageData(ImageUtil.compressImage(bytes));
//        Optional<Image> image = Optional.of(tempImage);
//        Mockito.when(imageRepository.findByName("tree")).thenReturn(image);
//        var actual = imageService.getImage("tree");
//
//         assertEquals(4, actual.length);
//         assertEquals(0, actual[0]);
//    }

//    @Test
//    void getImageTestReturnNull() {
//        Mockito.when(imageRepository.findByName("apple")).thenReturn(null);
//        var actual = imageService.getImage("apple");
//        assertNull(actual);
//    }

//    @Test
//    void getImageTestImageIsNull() {
//        Image tempImage = TestData.images.get(0);
//        Optional<Image> image = Optional.of(tempImage);
//        Mockito.when(imageRepository.findByName("tree")).thenReturn(image);
//        var actual = imageService.getImage("tree");
//
//        assertNull(actual);
//    }
}
