package com.example.cardealership.services;

import com.example.cardealership.dtos.BrandDto;

import java.util.List;

public interface BrandService {
    public void addBrand(BrandDto brandDto);
    public List<BrandDto> allBrand();
}
