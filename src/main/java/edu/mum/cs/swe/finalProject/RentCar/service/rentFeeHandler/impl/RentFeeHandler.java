package edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.impl;

import edu.mum.cs.swe.finalProject.RentCar.model.rent.RentRecord;
import edu.mum.cs.swe.finalProject.RentCar.repository.IRentRecordRepository;
import edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.IRentFeeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentFeeHandler implements IRentFeeHandler {
    @Autowired
    private IRentRecordRepository rentRecordRepository;
    @Override
    public List<RentRecord> findAll() {
        return rentRecordRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        rentRecordRepository.deleteById(id);

    }

    @Override
    public void save(RentRecord rentRecord) {
        rentRecordRepository.save(rentRecord);
    }

    @Override
    public RentRecord findOne(long id) {
        return rentRecordRepository.getOne(id);
    }
}
