package edu.mum.cs.swe.finalProject.RentCar.service.PaymentInfoValidatorStrategy;

import edu.mum.cs.swe.finalProject.RentCar.model.payment.PaymentInfo;
import edu.mum.cs.swe.finalProject.RentCar.service.IPaymentInfoValidator;
import edu.mum.cs.swe.finalProject.RentCar.service.PaymentInfoValidatorStrategy.strategy.CardcheckStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisaStrategy implements CardcheckStrategies {
    @Autowired
    private IPaymentInfoValidator paymentInfoValidator;


    public boolean isValid(PaymentInfo paymentInfo) {
        boolean isValid = true;

        isValid = paymentInfo.getCardNumber().startsWith("4");

        if(isValid) {
            isValid = paymentInfo.getCardNumber().length() == 16;
        }

        if(isValid) {
            isValid = paymentInfoValidator.passesLuhn(paymentInfo);
        }

        return isValid;
    }
}
