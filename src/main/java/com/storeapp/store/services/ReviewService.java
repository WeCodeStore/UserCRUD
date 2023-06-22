package com.storeapp.store.services;

import com.storeapp.store.models.Review;
import com.storeapp.store.models.ReviewDTO;
import com.storeapp.store.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<ReviewDTO> getAllReviews() {
        var reviewList = reviewRepository.findAll();
        var dtoList = new ArrayList<ReviewDTO>();
        for(Review review: reviewList) {
            dtoList.add(modelMapper.map(review, ReviewDTO.class));
        }
        return dtoList;
    }

    public List<ReviewDTO> getReviewsByProduct(int productId) {
        var reviewList = reviewRepository.findByProductId(productId);
        var dtoList = new ArrayList<ReviewDTO>();
        for(Review review: reviewList) {
            dtoList.add(modelMapper.map(review, ReviewDTO.class));
        }
        return dtoList;
    }

    public List<ReviewDTO> getReviewsByUser(int userId) {
        var reviewList = reviewRepository.findByUserId(userId);
        var dtoList = new ArrayList<ReviewDTO>();
        for(Review review: reviewList) {
            dtoList.add(modelMapper.map(review, ReviewDTO.class));
        }
        return dtoList;
    }
}
