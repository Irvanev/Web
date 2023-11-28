package com.example.cardealership.repositories;

import com.example.cardealership.models.Brand;
import com.example.cardealership.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, String> {
    Optional<Model> findByName(String name);
}
