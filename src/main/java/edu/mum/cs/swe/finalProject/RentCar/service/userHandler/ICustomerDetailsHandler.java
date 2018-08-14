package edu.mum.cs.swe.finalProject.RentCar.service.userHandler;

import edu.mum.cs.swe.finalProject.RentCar.model.user.Customer;
import edu.mum.cs.swe.finalProject.RentCar.model.user.User;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.VehicleCategory;

import java.util.List;

public interface ICustomerDetailsHandler {
    List<Customer> findAll();
    void deleteById(long id);
    void save(Customer customer);
    Customer findOne(long id);
}
