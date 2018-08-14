package edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler.impl;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;
import edu.mum.cs.swe.finalProject.RentCar.repository.IVehicleRepository;
import edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler.IVehicleDetailHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDetailHandler implements IVehicleDetailHandler {

    @Autowired
     private IVehicleRepository vehicleRepository;


    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

        vehicleRepository.deleteById(id);

    }

    @Override
    public void save(Vehicle vehicle) {

        vehicleRepository.save(vehicle);

    }

    @Override
    public Vehicle findOne(long id) {
        return vehicleRepository.getOne(id);
    }
}
