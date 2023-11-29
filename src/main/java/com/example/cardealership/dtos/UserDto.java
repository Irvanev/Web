package com.example.cardealership.dtos;

import com.example.cardealership.constants.RoleEnum;
import com.example.cardealership.util.UniqueUserName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class UserDto {
    private RoleEnum roleName;
    @UniqueUserName
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isActive;
    private String imageURL;
    private LocalDateTime created;
    private LocalDateTime modified;

    public RoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }

    @NotEmpty
    @Length(min = 5, message = "UserName must be more than 5 characters!")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotEmpty
    @Length(min = 2, message = "First name must be more than 2 characters!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty
    @Length(min = 2, message = "Last name must be more than 2 characters!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotEmpty
    @Length(min = 10, message = "Password must be more than 10 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "Please choose an online of user!")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @NotEmpty(message = "URL of image cannot be null or empty!")
    @Length(min = 10, max = 100, message = "URL of image must be more than 10 characters!")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @NotNull(message = "Local date cannot be null or empty!")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @NotNull(message = "Local date cannot be null or empty!")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
