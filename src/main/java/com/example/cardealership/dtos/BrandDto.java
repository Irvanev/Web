package com.example.cardealership.dtos;

import com.example.cardealership.util.UniqueBrandName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class BrandDto {
    @UniqueBrandName
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    @NotEmpty
    @Length(min = 2, message = "Name of brand must be more than 2 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
