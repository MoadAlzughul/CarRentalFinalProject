package edu.mum.cs.swe.finalProject.RentCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.swe.finalProject.RentCar.model.user.Customer;

public interface IUserRepository extends JpaRepository<Customer,Long> {

}
