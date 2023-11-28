package com.example.cardealership.controllers;

import com.example.cardealership.dtos.BrandDto;
import com.example.cardealership.models.Brand;
import com.example.cardealership.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }


    @ModelAttribute("brandsModel")
    public BrandDto initBrand() {
        return new BrandDto();
    }

    @GetMapping("/all")
    public String getAllBrands(Model model) {
        model.addAttribute("brands", brandService.allBrand());
        return "brand";
    }
    @PostMapping("/add")
    public String addBrand(@Valid BrandDto brandDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("brandsModel", brandDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.brandsModel",
                    result);
            return "redirect:/brands/all";
        }
        brandService.addBrand(brandDto);
        return "redirect:/brands/all";
    }
}
