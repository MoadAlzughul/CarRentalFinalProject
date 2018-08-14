package edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IVehicleDetailHandler {

    List<Vehicle> findAll();
    void deleteById(long id);
    void save(Vehicle vehicle);
    Vehicle findOne(long id);

}
