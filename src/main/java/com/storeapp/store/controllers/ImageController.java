package com.storeapp.store.controllers;

import com.storeapp.store.models.ImageDTO;
import com.storeapp.store.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/store/image")
public class ImageController {
    @Autowired
    private ImageService imageDataService;

    @PostMapping(value="upload/file",
                 consumes={MediaType.MULTIPART_FORM_DATA_VALUE},
                 produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("productId") Long productId) throws IOException {
       try {
           String response = imageDataService.uploadImage(file, productId);

           return ResponseEntity.status(HttpStatus.OK)
                   .body(response);
       } catch (Exception e){
           return ResponseEntity.badRequest().header("Error", "Failed to insert image").build();
       }
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<?>  getImageInfoByName(@PathVariable("name") String name){
        ImageDTO image = imageDataService.getInfoByImageByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/byproduct/{productId}")
    public ResponseEntity<?>  getImagesByProduct(@PathVariable("productId") Long productId){
        if (productId <= 0){
            return ResponseEntity.badRequest().header("Error", "The image product id must be positive number. ").build();
        }
            List<ImageDTO> lstImageDTO = imageDataService.getImageByProductId(productId);
            if (lstImageDTO != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(lstImageDTO);
            }
            else{
                return ResponseEntity.badRequest().header("Error", "Image does not exist").build();
            }
    }

    @GetMapping("/all")
    public ResponseEntity<?>  getAllImages(){

        List<ImageDTO> lstImageDTO = imageDataService.getAllImages();
        if (lstImageDTO != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(lstImageDTO);
        }
        else{
            return ResponseEntity.badRequest().header("Error", "No Images").build();
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?>  getImageByName(@PathVariable("name") String name){
        if (name == null || name.isEmpty()){
            return ResponseEntity.badRequest().header("Error", "The image name should not be empty. ").build();
        }
        byte[] image = imageDataService.getImage(name);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}
