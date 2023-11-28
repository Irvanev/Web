package com.example.cardealership.dtos;

import com.example.cardealership.constants.RoleEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RoleDto {
    private RoleEnum roleEnum;

    @NotNull(message = "Please choose an role!")
    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
