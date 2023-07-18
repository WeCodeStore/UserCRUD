package com.storeapp.store.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private long productId;
    private String name;
    private double price;
    private long quantity;
    private String sku;
    private String faceImage;
    private List<String> images;
    private String description;
    private String category;
    private double avgReviewRate;
    private long totalReviews;

    public void setCategory(Category category) {
        var catName = category.getName();
        this.category = catName;
    }

    public void setImages(List<Image> images) {
        var list = new ArrayList<String>();
        for(Image image : images) {
            list.add(image.getImageUrl());
        }
        this.images = list;
    }


}
