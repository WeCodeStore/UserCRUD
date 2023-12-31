package com.storeapp.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String name;
    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    private String imageUrl;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="productId")
    @JsonIgnore
    private Product product;

    public Image(String imageUrl){
        this.imageUrl= imageUrl;
    }

    @Override
    public boolean equals(Object o){
       if (this == o) return true;
       if (!(o instanceof Image)) return false;
       return imageId != null && imageId.equals(((Image) o).getImageId());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
