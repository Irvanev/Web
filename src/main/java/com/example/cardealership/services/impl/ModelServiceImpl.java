package com.example.cardealership.services.impl;

import com.example.cardealership.dtos.ModelDto;
import com.example.cardealership.models.Model;
import com.example.cardealership.repositories.BrandRepository;
import com.example.cardealership.repositories.ModelRepository;
import com.example.cardealership.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelMapper modelMapper, ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    public void addModel(ModelDto modelDto) {
        Model model = modelMapper.map(modelDto, Model.class);
        model.setBrand(brandRepository.findByName(modelDto.getBrandName()).orElse(null));

        modelRepository.saveAndFlush(model);
    }
    public List<ModelDto> allModels() {
        return modelRepository.findAll().stream().map(model -> modelMapper.map(model, ModelDto.class))
                .collect(Collectors.toList());
    }
}
