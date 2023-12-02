package com.example.cardealership.services.impl;

import com.example.cardealership.dtos.OfferDto;
import com.example.cardealership.models.Offer;
import com.example.cardealership.repositories.ModelRepository;
import com.example.cardealership.repositories.OfferRepository;
import com.example.cardealership.repositories.UserRepository;
import com.example.cardealership.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(ModelRepository modelRepository, OfferRepository offerRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void addOffer(OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        offer.setModel(modelRepository.findByName(offerDto.getModelName()).orElse(null));
        offer.setUsers(userRepository.findByUserName(offerDto.getUserName()).orElse(null));

        offerRepository.saveAndFlush(offer);
    }
    public List<OfferDto> allOffers() {
        return offerRepository.findAll().stream().map(offer -> modelMapper.map(offer, OfferDto.class))
                .collect(Collectors.toList());
    }
}
