package com.storeapp.store.controllers;

import com.storeapp.store.models.ReviewDTO;
import com.storeapp.store.repository.ReviewRepository;
import com.storeapp.store.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("store/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewRepository rep;

    @GetMapping("")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        var reviews = reviewService.getAllReviews();
        if (reviews == null || reviews.size() == 0){
           return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByProduct(@PathVariable long id) {
        int productId = 0;
       /* try {
            productId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return ResponseEntity.badRequest().header("Error: ", "Invalid product ID.").build();
        } */

        if (id <= 0){
            return ResponseEntity.badRequest().header("Error", "Invalid product ID").build();
        }

        var reviews = reviewService.getReviewsByProduct(id);

        if (reviews == null || reviews.size() == 0){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByUser(@PathVariable long id) {
        int userId = 0;
       /* try {
            userId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return ResponseEntity.badRequest().header("Error: ", "Invalid product ID.").build();
        } */
        if (id <= 0){
            return ResponseEntity.badRequest().header("Error", "Invalid user ID").build();
        }


        var reviews = reviewService.getReviewsByUser(id);
        if (reviews == null || reviews.size() == 0){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reviews);
    }
}
