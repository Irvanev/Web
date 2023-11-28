package com.example.cardealership.services.impl;

import com.example.cardealership.dtos.ModelDto;
import com.example.cardealership.dtos.RoleDto;
import com.example.cardealership.models.Role;
import com.example.cardealership.repositories.RoleRepository;
import com.example.cardealership.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(ModelMapper modelMapper, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    public void addRole(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        roleRepository.saveAndFlush(role);
    }

    public List<RoleDto> allRoles() {
        return roleRepository.findAll().stream().map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }
}
