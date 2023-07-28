package com.storeapp.store.repository;

import com.storeapp.store.models.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByName(String name);

    @Transactional
    @Query(value = "Select * from image  i where i.productId = :productId", nativeQuery = true)
    List<Image> findAllByProductId(@Param("productId") Long productId);
}
