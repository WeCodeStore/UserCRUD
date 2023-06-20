package com.storeapp.store.controllers;

import com.storeapp.store.models.ReviewDTO;
import com.storeapp.store.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("")
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/product/{id}")
    public List<ReviewDTO> getReviewsByProduct(@PathVariable String id) {
        int productId = 0;
        try {
            productId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
        return reviewService.getReviewsByProduct(productId);
    }

    @GetMapping("/user/{id}")
    public List<ReviewDTO> getReviewsByUser(@PathVariable String id) {
        int userId = 0;
        try {
            userId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
        return reviewService.getReviewsByUser(userId);
    }

}
