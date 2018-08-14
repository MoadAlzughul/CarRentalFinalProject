package edu.mum.cs.swe.finalProject.RentCar.service.userHandler.impl;

import edu.mum.cs.swe.finalProject.RentCar.model.user.Customer;
import edu.mum.cs.swe.finalProject.RentCar.model.user.User;
import edu.mum.cs.swe.finalProject.RentCar.repository.IUserRepository;
import edu.mum.cs.swe.finalProject.RentCar.service.userHandler.ICustomerDetailsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsHandler  implements ICustomerDetailsHandler {

  @Autowired
 private IUserRepository userRepository;

    @Override
    public List<Customer> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void save(Customer customer) {
        userRepository.save(customer);

    }

    @Override
    public Customer  findOne(long id) {
        return userRepository.getOne(id);
    }
}
