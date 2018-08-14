package edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler.impl;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.VehicleCategory;
import edu.mum.cs.swe.finalProject.RentCar.repository.IVehicleCategoryRepository;
import edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler.IVehicleCategoryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleCategoryHandler implements IVehicleCategoryHandler {
@Autowired
private IVehicleCategoryRepository vehicleCategoryRepository;
    @Override
    public List<VehicleCategory> findAll() {
        return vehicleCategoryRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
       vehicleCategoryRepository.deleteById(id);
    }

    @Override
    public void save(VehicleCategory vehicleCategory) {
vehicleCategoryRepository.save(vehicleCategory);
    }

    @Override
    public VehicleCategory findOne(long id) {
        return vehicleCategoryRepository.getOne(id);
    }
}
