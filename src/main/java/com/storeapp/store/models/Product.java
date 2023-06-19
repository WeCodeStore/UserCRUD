package com.storeapp.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @SequenceGenerator(name="product_seq", initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Min(value=1)
    @Column(name="productId")
    @Id
    private long productId;
    private String name;
    private double price;
    private long quantity;
    private String sku;

    private String description;
    private long categoryId;

    @OneToMany( mappedBy="product",
            cascade=CascadeType.ALL
    )
   // @JoinColumn(name="imageId")
    private List<Image> images = new ArrayList<>();

    public void addImage(Image image){
        images.add(image);
      //  image.setProduct(this);
    }

    public void removeImage(Image image){
        images.remove(image);
     //   image.setProduct(null);
    }

}
