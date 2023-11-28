package com.example.cardealership.services;

import com.example.cardealership.dtos.OfferDto;

import java.util.List;

public interface OfferService {
    public void addOffer(OfferDto offerDto);
    public List<OfferDto> allOffers();
}
