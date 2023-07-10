package com.storeapp.store.repository;

import com.storeapp.store.models.ProductRate;
import com.storeapp.store.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductId(long id);

    List<Review> findByUserId(int userId);

    /*
  @Transactional
    @Query (value = "Select  '' as COMMENT, avg(rating) AS rating, count(id) as id, 1 as userId, productId from review r where r.productId = :id group by r.productId", nativeQuery = true)
    Review getReviewRateByProductId( @Param("id") long  id);
   */


 /* @Query("SELECT " +
            "    new com.storeapp.store.models.ProductRate(avg(v.rating), COUNT(v.id))  " +
            "FROM review AS v GROUP BY v.productId")
    List<ProductRate> getProductRate();  */


  // @Query("SELECT avg(v.RATING) AS rates, COUNT(v.id) AS count FROM review AS v GROUP BY v.PRODUCTID")
  //  List<ProductRate> getProductRate();

}
