package edu.mum.cs.swe.finalProject.RentCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.VehicleCategory;

public interface IVehicleCategoryRepository extends JpaRepository<VehicleCategory,Long> {
}
