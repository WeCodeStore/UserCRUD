package com.storeapp.store.controllers;

import com.storeapp.store.services.ReviewService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReviewControllerTest {

    @Mock
    ReviewService reviewService;

    @InjectMocks
    ReviewController reviewController;

    @Test
    void getAllReviewsTest() {
        var expected = TestData.reviewDtoList;
        Mockito.when(reviewService.getAllReviews()).thenReturn(expected);
        var actual = reviewController.getAllReviews();
        assertEquals(expected.get(0).getComment(), actual.getBody().get(0).getComment());
    }

    @Test
    void getAllReviewsTestReturnsNull() {
        Mockito.when(reviewService.getAllReviews()).thenReturn(null);
        var actual = reviewController.getAllReviews();
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }

    @Test
    void getReviewsByProductTest() {
        var expected = TestData.reviewDtoList;
        Mockito.when(reviewService.getReviewsByProduct(1)).thenReturn(expected);
        var actual = reviewController.getReviewsByProduct(1);
        assertEquals(expected.get(0).getComment(), actual.getBody().get(0).getComment());
    }

   /* @Test
    void getReviewsByProductReturnsEmptyListIfInvalidTest() {
        var actual = reviewController.getReviewsByProduct("asd");
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
    } */

    @Test
    void getReviewsByUserTest() {
        var expected = TestData.reviewDtoList;
        Mockito.when(reviewService.getReviewsByUser(1)).thenReturn(expected);
        var actual = reviewController.getReviewsByUser(1);
        assertEquals(expected.get(0).getComment(), actual.getBody().get(0).getComment());
    }

   /* @Test
    void getReviewsByUserReturnsEmptyListIfInvalidTest() {
        var actual = reviewController.getReviewsByUser("asd");
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
    } */
}
