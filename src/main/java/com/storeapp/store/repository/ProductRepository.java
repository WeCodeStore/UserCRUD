package com.storeapp.store.repository;

import com.storeapp.store.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByProductId(long productId);

    List<Product> findAllByCategoryId(long categoryId);

    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByCategoryId(long categoryId, Pageable pageable);
}
