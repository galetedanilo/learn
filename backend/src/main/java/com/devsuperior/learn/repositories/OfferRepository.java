package com.devsuperior.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.learn.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{

}
