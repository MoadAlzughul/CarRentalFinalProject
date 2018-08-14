package edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler;

import edu.mum.cs.swe.finalProject.RentCar.model.rent.Promo;
import edu.mum.cs.swe.finalProject.RentCar.model.rent.RentRecord;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;
import edu.mum.cs.swe.finalProject.RentCar.repository.IPromoRepository;
import edu.mum.cs.swe.finalProject.RentCar.repository.IVehicleRepository;



public class RentReturnlDirector {


  private IPromoRepository promoRepository;
    private IRentRecordBuilder rentRecordBuilder=null;

    private IVehicleRepository vehicleRepository;
    private RentRecord r;

    public RentReturnlDirector(IRentRecordBuilder rentRecordBuilder,IPromoRepository promoRepository,IVehicleRepository vehicleRepository) {
        this.rentRecordBuilder = rentRecordBuilder;
        this.promoRepository=promoRepository;
        this.vehicleRepository=vehicleRepository;
    }
    public void performCheckout() {
     r =rentRecordBuilder.intialize();
        Promo promo=rentRecordBuilder.buildPromo();
      if(promo!=null){

         promoRepository.save(promo);
         r.setPromo(promo);

      }
        Vehicle v=rentRecordBuilder.buildVehicle(r);
      vehicleRepository.save(v);

    }
    public RentRecord getRecord() {
        return rentRecordBuilder.getRentRecord(r);
    }
}
