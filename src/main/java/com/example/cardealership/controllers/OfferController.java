package com.example.cardealership.controllers;

import com.example.cardealership.dtos.OfferDto;
import com.example.cardealership.services.ModelService;
import com.example.cardealership.services.OfferService;
import com.example.cardealership.services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private ModelMapper modelMapper;
    private OfferService offerService;
    private ModelService modelService;
    private UserService userService;

    @Autowired
    public void setOfferService(OfferService offerService, ModelService modelService, UserService userService) {
        this.offerService = offerService;
        this.modelService = modelService;
        this.userService = userService;
    }
    @ModelAttribute("offersModel")
    public OfferDto initOffer() {
        return new OfferDto();
    }

    @GetMapping("/all")
    public String getAllOffers(Model model) {
        model.addAttribute("allOffers", offerService.allOffers());
        model.addAttribute("availableModels", modelService.allModels());
        model.addAttribute("availableUsers", userService.allUsers());
        return "offer";
    }
    @PostMapping("/add")
    public String addOffer(@Valid OfferDto offerDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("offersModel", offerDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.offersModel",
                    result);
            return "redirect:/models/all";
        }
        offerService.addOffer(offerDto);
        return "redirect:/models/all";
    }
}
