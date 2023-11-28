package com.example.cardealership.services;

import com.example.cardealership.dtos.ModelDto;

import java.util.List;

public interface ModelService {
    public void addModel(ModelDto modelDto);
    public List<ModelDto> allModels();
}
