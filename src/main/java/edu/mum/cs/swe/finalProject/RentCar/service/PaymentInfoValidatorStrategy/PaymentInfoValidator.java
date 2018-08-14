package edu.mum.cs.swe.finalProject.RentCar.service.PaymentInfoValidatorStrategy;

import edu.mum.cs.swe.finalProject.RentCar.model.payment.PaymentInfo;
import edu.mum.cs.swe.finalProject.RentCar.service.IPaymentInfoValidator;
import org.springframework.stereotype.Service;


@Service
public  class PaymentInfoValidator implements IPaymentInfoValidator {

    public boolean passesLuhn(PaymentInfo paymentInfo) {
        String ccNumber=paymentInfo.getCardNumber().toString();
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

}
