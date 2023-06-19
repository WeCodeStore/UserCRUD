package com.storeapp.store.services;

import com.storeapp.store.helper.ImageUtil;
import com.storeapp.store.models.Image;
import com.storeapp.store.models.Product;
import com.storeapp.store.repository.ImageDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {
    @Autowired
    private ImageDataRepository imageDataRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        imageDataRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        return "Image uploaded successfully: " + file.getOriginalFilename();
    }

    @Transactional
    public Image getInfoByImageByName(String name) {
        Optional<Image> dbImage = imageDataRepository.findByName(name);
        if (dbImage.isPresent()) {
            Image image= dbImage.get();
            if (image.getImageData() != null) {
                return Image.builder()
                        .name(image.getName())
                        .imageId(image.getImageId())
                        .product(image.getProduct())
                        .imageUrl(image.getImageUrl())
                        .type(image.getType())
                        .imageData(ImageUtil.decompressImage(image.getImageData())).build();
            } else{
                return image;
            }
        }

        return null;
    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<Image> dbImage = imageDataRepository.findByName(name);
        byte[] image = null;

        if (dbImage.isPresent() && dbImage.get().getImageData() != null) {
            image = ImageUtil.decompressImage(dbImage.get().getImageData());
        }
        return image;
    }

}
