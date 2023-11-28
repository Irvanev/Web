package com.example.cardealership.controllers;

import com.example.cardealership.dtos.ModelDto;
import com.example.cardealership.dtos.RoleDto;
import com.example.cardealership.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @ModelAttribute("rolesModel")
    public RoleDto initRole() {
        return new RoleDto();
    }

    @GetMapping("/all")
    public String getAllRoles(Model model) {
        model.addAttribute("allRoles", roleService.allRoles());
        model.addAttribute("availableRole", roleService.allRoles());
        return "role";
    }
    @PostMapping("/add")
    public String addRole(@Valid RoleDto roleDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("rolesModel", roleDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.modelsModel",
                    result);
            return "redirect:/roles/all";
        }
        roleService.addRole(roleDto);
        return "redirect:/roles/all";
    }
}
