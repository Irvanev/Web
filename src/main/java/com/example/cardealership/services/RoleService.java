package com.example.cardealership.services;

import com.example.cardealership.dtos.ModelDto;
import com.example.cardealership.dtos.RoleDto;
import com.example.cardealership.models.Role;

import java.util.List;

public interface RoleService {
    public void addRole(RoleDto roleDto);
    public List<RoleDto> allRoles();
}
