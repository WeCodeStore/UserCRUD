package com.storeapp.store.models;

import com.storeapp.store.helper.ImageUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImageDTO {
    private Long imageId;
    private String name;
    private String type;
    private byte[] imageData;
    private String imageUrl;

    public void setImageData(byte[] imageData) {
        if (imageData != null){
            this.imageData = ImageUtil.decompressImage(imageData);
        } else {
            this.imageData = null;
        }
    }

}
