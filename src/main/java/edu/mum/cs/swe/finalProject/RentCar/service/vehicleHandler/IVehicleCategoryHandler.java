package edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.VehicleCategory;

import java.util.List;

public interface IVehicleCategoryHandler {
    List<VehicleCategory> findAll();
    void deleteById(long id);
    void save(VehicleCategory vehicleCategory);
    VehicleCategory findOne(long id);

}
