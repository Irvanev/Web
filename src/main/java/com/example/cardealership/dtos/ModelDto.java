package com.example.cardealership.dtos;

import com.example.cardealership.constants.CategoryEnum;
import com.example.cardealership.util.UniqueModelName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class ModelDto {
    private String brandName;
    @UniqueModelName
    private String name;
    private CategoryEnum categoryEnum;
    private String imageURL;
    private int startYear;
    private int endYear;
    private LocalDateTime created;
    private LocalDateTime modified;

    @NotEmpty(message = "Name of brand cannot be null or empty!")
    @Size(min = 2, message = "Name of brand should be at least 2 characters long!")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @NotEmpty(message = "Name of model cannot be null or empty!")
    @Size(min = 2, message = "Name of model should be at least 2 characters long!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Please choose an category!")
    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    @NotEmpty(message = "URL of image cannot be null or empty!")
    @Length(min = 10, max = 100, message = "URL of image must be more than 10 characters!")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Min(value = 1, message = "Start year must be a positive number!")
    @NotNull(message = "Start year must not be null or empty!")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Min(value = 1, message = "End year must be a positive number!")
    @NotNull(message = "End year must not be null or empty!")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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
