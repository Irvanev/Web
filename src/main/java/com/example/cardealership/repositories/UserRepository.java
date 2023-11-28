package com.example.cardealership.repositories;

import com.example.cardealership.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUserName(String userName);
}
