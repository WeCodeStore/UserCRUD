package com.storeapp.store.services;

import com.storeapp.store.models.ReviewDTO;
import com.storeapp.store.repository.ReviewRepository;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReviewServiceTest {

    @Mock
    ReviewRepository reviewRepository;

    @InjectMocks
    ReviewService reviewService;

    @Test
    void getAllReviewsTest() {
        Mockito.when(reviewRepository.findAll()).thenReturn(TestData.reviewList);
        var actual = reviewService.getAllReviews();
        assertEquals("comment", actual.get(0).getComment());
        assertThat(actual.get(0)).isInstanceOf(ReviewDTO.class);
    }

    @Test
    void getAllReviewsReturnsEmptyListTest() {
        Mockito.when(reviewRepository.findAll()).thenReturn(new ArrayList<>());
        var actual = reviewService.getAllReviews();
        assertEquals(0, actual.size());
    }

    @Test
    void getReviewsByProductIdTest() {
        Mockito.when(reviewRepository.findByProductId(1)).thenReturn(TestData.reviewList);
        var actual = reviewService.getReviewsByProduct(1);
        assertEquals("comment", actual.get(0).getComment());
        assertThat(actual.get(0)).isInstanceOf(ReviewDTO.class);
    }

    @Test
    void getAllReviewsByProductIdReturnsEmptyListTest() {
        Mockito.when(reviewRepository.findByProductId(2)).thenReturn(new ArrayList<>());
        var actual = reviewService.getReviewsByProduct(2);
        assertEquals(0, actual.size());
    }

    @Test
    void getReviewsByUserIdTest() {
        Mockito.when(reviewRepository.findByUserId(1)).thenReturn(TestData.reviewList);
        var actual = reviewService.getReviewsByUser(1);
        assertEquals("comment", actual.get(0).getComment());
        assertThat(actual.get(0)).isInstanceOf(ReviewDTO.class);
    }

    @Test
    void getAllReviewsByUserIdReturnsEmptyListTest() {
        Mockito.when(reviewRepository.findByUserId(2)).thenReturn(new ArrayList<>());
        var actual = reviewService.getReviewsByUser(2);
        assertEquals(0, actual.size());
    }
}
