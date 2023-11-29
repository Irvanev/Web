package com.example.cardealership.controllers;

import com.example.cardealership.dtos.BrandDto;
import com.example.cardealership.dtos.UserDto;
import com.example.cardealership.services.BrandService;
import com.example.cardealership.services.RoleService;
import com.example.cardealership.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @ModelAttribute("usersModel")
    public UserDto iniUser() {
        return new UserDto();
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("availableRole", roleService.allRoles());
        return "users";
    }
    @PostMapping("/add")
    public String addUser(@Valid UserDto userDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("usersModel", userDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.usersModel",
                    result);
            return "redirect:/users/all";
        }
        userService.addUser(userDto);
        return "redirect:/users/all";
    }

    @GetMapping("/userDelete/{name}")
    public String removeUser(@PathVariable("name") String userName) {
        userService.removeUser(userName);

        return "redirect:/users/all";
    }
}

