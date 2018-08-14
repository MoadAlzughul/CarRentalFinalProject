package edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler;



import edu.mum.cs.swe.finalProject.RentCar.model.rent.RentRecord;

import java.util.List;

public interface IRentFeeHandler  {
    List<RentRecord> findAll();
    void deleteById(long id);
    void save(RentRecord rentRecord);
    RentRecord findOne(long id);
}
