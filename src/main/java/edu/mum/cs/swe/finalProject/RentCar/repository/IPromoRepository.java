package edu.mum.cs.swe.finalProject.RentCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.swe.finalProject.RentCar.model.rent.Promo;

public interface IPromoRepository extends JpaRepository<Promo,Long> {
}
