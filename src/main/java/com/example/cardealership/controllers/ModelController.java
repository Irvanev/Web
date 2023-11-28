package com.example.cardealership.controllers;

import com.example.cardealership.dtos.ModelDto;
import com.example.cardealership.services.BrandService;
import com.example.cardealership.services.ModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    private BrandService brandService;

    @Autowired
    public void setModelService(ModelService modelService, BrandService brandService) {
        this.modelService = modelService;
        this.brandService = brandService;
    }


    @ModelAttribute("modelsModel")
    public ModelDto initModel() {
        return new ModelDto();
    }

    @GetMapping("/all")
    public String getAllModels(Model model) {
        model.addAttribute("allModels", modelService.allModels());
        model.addAttribute("availableBrands", brandService.allBrand());
        return "models";
    }
    @PostMapping("/add")
    public String addModel(@Valid ModelDto modelDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("modelsModel", modelDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.modelsModel",
                    result);
            return "redirect:/models/all";
        }
        modelService.addModel(modelDto);
        return "redirect:/models/all";
    }

    @GetMapping("/modelDelete/{name}")
    public String removeModel(@PathVariable("name") String name) {
        modelService.removeModel(name);

        return "redirect:/models/all";
    }
}
