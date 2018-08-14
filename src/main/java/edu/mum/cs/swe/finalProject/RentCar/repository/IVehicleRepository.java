package edu.mum.cs.swe.finalProject.RentCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle,Long> {
}
