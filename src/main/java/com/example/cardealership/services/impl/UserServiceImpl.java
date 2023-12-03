package com.example.cardealership.services.impl;

import com.example.cardealership.dtos.BrandDto;
import com.example.cardealership.dtos.UserDto;
import com.example.cardealership.models.Users;
import com.example.cardealership.repositories.RoleRepository;
import com.example.cardealership.repositories.UserRepository;
import com.example.cardealership.services.UserService;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void addUser(UserDto userDto) {
        userDto.setCreated(LocalDateTime.now());
        userDto.setModified(LocalDateTime.now());
        userDto.setActive(false);
        Users users = modelMapper.map(userDto, Users.class);
        users.setRole(roleRepository.findByRoleEnum(userDto.getRoleName()).orElse(null));

        userRepository.saveAndFlush(users);
    }
    public List<UserDto> allUsers() {
        return userRepository.findAll().stream().map(users -> modelMapper.map(users, UserDto.class))
                .collect(Collectors.toList());
    }
    public void removeUser(String userName) {
        userRepository.deleteByUserName(userName);
    }
}
