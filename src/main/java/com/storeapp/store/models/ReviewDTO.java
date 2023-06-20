package com.storeapp.store.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    private long id;
    private String comment;
    private double rating;
    private long productId;
    private long userId;

//    public void setUser(User user) {
//        this.user = user.getUsername();
//    }
}
