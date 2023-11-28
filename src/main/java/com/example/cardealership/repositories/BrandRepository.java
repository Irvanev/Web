package com.example.cardealership.repositories;

import com.example.cardealership.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, String> {

    Optional<Brand> findByName(String name);
    @Modifying
    @Transactional
    void deleteByName(String name);
}
