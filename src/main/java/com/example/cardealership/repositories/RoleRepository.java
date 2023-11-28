package com.example.cardealership.repositories;

import com.example.cardealership.constants.RoleEnum;
import com.example.cardealership.models.Brand;
import com.example.cardealership.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRoleEnum(RoleEnum roleEnum);
}
