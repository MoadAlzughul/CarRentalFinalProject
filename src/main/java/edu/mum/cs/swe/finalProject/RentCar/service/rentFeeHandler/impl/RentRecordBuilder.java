package edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.impl;

import edu.mum.cs.swe.finalProject.RentCar.model.rent.Promo;
import edu.mum.cs.swe.finalProject.RentCar.model.rent.RentRecord;
import edu.mum.cs.swe.finalProject.RentCar.model.user.Customer;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;
import edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.IRentRecordBuilder;
import edu.mum.cs.swe.finalProject.RentCar.service.userHandler.ICustomerDetailsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class RentRecordBuilder implements IRentRecordBuilder {


    private ICustomerDetailsHandler customerDetailsHandler;


    private long customerid;
    private  double latefee;
    private  double totalfee;
    private String promocode;
    private  double promovalue;


    public RentRecordBuilder(long customerid, double latefee, double totalfee, String promocode, double promovalue,ICustomerDetailsHandler customerDetailsHandler) {
        this.customerid = customerid;
        this.latefee = latefee;
        this.totalfee = totalfee;
        this.promocode = promocode;
        this.promovalue = promovalue;
        this.customerDetailsHandler=customerDetailsHandler;
    }

    public RentRecordBuilder(){

    }

    @Override
    public RentRecord intialize() {
        return customerDetailsHandler.findOne(customerid).getRentrecord().get(0);
    }

    @Override
    public Promo buildPromo() {
        Promo promo=new Promo(promocode,promovalue);
        return promo;
    }

    @Override
    public Vehicle buildVehicle(RentRecord rentRecord) {
       Vehicle v= rentRecord.getVehicle();
       v.setAvailable(true);
       return v;

    }

    @Override
    public RentRecord getRentRecord(RentRecord rentRecord) {

        rentRecord.setLatefee(latefee);
        rentRecord.setTotalfee(totalfee);
        return  rentRecord;
    }
}
