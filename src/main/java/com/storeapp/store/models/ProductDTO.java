package com.storeapp.store.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String image;
    private String description;
    private String category;
    private double reviewRate;
    private long totalReviews;

    public void setCategory(Category category) {
        var catName = category.getName();
        this.category = catName;
    }
}
