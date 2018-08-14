package edu.mum.cs.swe.finalProject.RentCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.swe.finalProject.RentCar.model.payment.PaymentInfo;

public interface IPaymentInfoRepository extends JpaRepository<PaymentInfo,Long> {
}
