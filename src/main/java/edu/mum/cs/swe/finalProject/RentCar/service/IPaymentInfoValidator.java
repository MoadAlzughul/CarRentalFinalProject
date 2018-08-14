package edu.mum.cs.swe.finalProject.RentCar.service;

import edu.mum.cs.swe.finalProject.RentCar.model.payment.PaymentInfo;

public interface IPaymentInfoValidator {
    boolean passesLuhn(PaymentInfo paymentInfo);
}
