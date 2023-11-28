package com.example.cardealership.repositories;

import com.example.cardealership.models.Brand;
import com.example.cardealership.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, String> {
    Optional<Model> findByName(String name);

    @Modifying
    @Transactional
    void deleteByName(String name);
}
