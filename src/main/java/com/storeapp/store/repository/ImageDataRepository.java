package com.storeapp.store.repository;

import com.storeapp.store.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDataRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
}
