package edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler;

import edu.mum.cs.swe.finalProject.RentCar.model.rent.Promo;
import edu.mum.cs.swe.finalProject.RentCar.model.rent.RentRecord;
import edu.mum.cs.swe.finalProject.RentCar.model.user.Customer;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;

public interface IRentRecordBuilder {
    public  RentRecord intialize();
    public Promo buildPromo();
    Vehicle buildVehicle(RentRecord rentRecord);
    public RentRecord getRentRecord(RentRecord rentRecord);
}
