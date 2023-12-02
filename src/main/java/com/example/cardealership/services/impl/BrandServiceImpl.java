package com.example.cardealership.services.impl;

import com.example.cardealership.dtos.BrandDto;
import com.example.cardealership.models.Brand;
import com.example.cardealership.repositories.BrandRepository;
import com.example.cardealership.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelMapper modelMapper, BrandRepository brandRepository) {
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
    }

    public void addBrand(BrandDto brandDto) {
        brandDto.setCreated(LocalDateTime.now());
        brandDto.setModified(LocalDateTime.now());
        brandRepository.saveAndFlush(modelMapper.map(brandDto, Brand.class));
    }

    public List<BrandDto> allBrand() {
        return brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, BrandDto.class))
                .collect(Collectors.toList());
    }
    public void removeBrand(String name) {
        brandRepository.deleteByName(name);
    }

}
