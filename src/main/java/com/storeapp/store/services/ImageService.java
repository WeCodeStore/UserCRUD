package com.storeapp.store.services;

import com.storeapp.store.helper.ImageUtil;
import com.storeapp.store.models.*;
import com.storeapp.store.repository.ImageRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageDataRepository;

    ModelMapper modelMapper = new ModelMapper();

    public String uploadImage(MultipartFile file, Long productId) throws IOException {
        imageDataRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        return "Image uploaded successfully: " + file.getOriginalFilename();
    }

 /*   @Transactional
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
    }  */

    @Transactional
    public ImageDTO getInfoByImageByName(String name) {
        Optional<Image> dbImage = imageDataRepository.findByName(name);

        if (dbImage.isPresent()) {
            return modelMapper.map(dbImage.get(), ImageDTO.class);
        }

        return null;
    }

    @Transactional
    public List<ImageDTO> getImageByProductId(Long id) {
        List<Image> images = imageDataRepository.findAllByProductId(id);

        var imageDTOList = new ArrayList<ImageDTO>();
        for (Image image: images) {
            imageDTOList.add(modelMapper.map(image, ImageDTO.class));
        }

        return imageDTOList;
    }

    @Transactional
    public List<ImageDTO> getAllImages() {
        List<Image> images = imageDataRepository.findAll();

        var imageDTOList = new ArrayList<ImageDTO>();
        for (Image image: images) {
            imageDTOList.add(modelMapper.map(image, ImageDTO.class));
        }

        return imageDTOList;
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
