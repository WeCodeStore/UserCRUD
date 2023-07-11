package com.storeapp.store.repository;

import com.storeapp.store.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductId(long id);

    List<Review> findByUserId(int userId);

    @Query(value="SELECT count(r) FROM Review r WHERE productId = ?1")
    long getProductTotalReviews(long productId);

    @Query(value="SELECT  AVG(r.rating) FROM Review r WHERE productId = ?1")
    Double getProductAvgReviewsRate(long productId);



}
