package com.example.cardealership.services;

import com.example.cardealership.dtos.UserDto;

import java.util.List;

public interface UserService {
    public void addUser(UserDto userDto);
    public List<UserDto> allUsers();
}
