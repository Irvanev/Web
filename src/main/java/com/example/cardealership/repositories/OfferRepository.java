package com.example.cardealership.repositories;

import com.example.cardealership.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, String> {

}
