package edu.mum.cs.swe.finalProject.RentCar.service.rentHandler;

import edu.mum.cs.swe.finalProject.RentCar.model.payment.PaymentInfo;
import edu.mum.cs.swe.finalProject.RentCar.model.rent.RentRecord;
import edu.mum.cs.swe.finalProject.RentCar.model.user.Address;
import edu.mum.cs.swe.finalProject.RentCar.model.user.Customer;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;
import edu.mum.cs.swe.finalProject.RentCar.repository.IAddressRepository;
import edu.mum.cs.swe.finalProject.RentCar.repository.IPaymentInfoRepository;
import edu.mum.cs.swe.finalProject.RentCar.repository.IRentRecordRepository;
import edu.mum.cs.swe.finalProject.RentCar.repository.IUserRepository;
import edu.mum.cs.swe.finalProject.RentCar.service.IPaymentInfoValidator;
import edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler.IVehicleDetailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class PaymentRecordHandler {

    @Autowired
    IRentRecordRepository rentRecordRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IVehicleDetailHandler vehicleDetailHandler;

    @Autowired
    IPaymentInfoRepository paymentInfoRepository;

    @Autowired
    IAddressRepository addressRepository;


    IPaymentInfoValidator paymentInfoValidator;


    Customer customer = new Customer();
    Vehicle vehicle = null;
    LocalDate pickUpdate = null;
    LocalDate dropOffDate = null;

//    public RentRecord(Vehicle vehicle, Customer customer, LocalDate rentDate, LocalDate returnDate, double fee)

    public void selectVehicle(long id) {
        vehicle = vehicleDetailHandler.findOne(id);

        System.out.println(vehicle.getMake());
    }

    public void setCustomerInfo(Customer customer, LocalDate pickUpdate, LocalDate dropOffDate) {
        this.customer.setFullName(customer.getFullName());
        this.customer.setEmail(customer.getEmail());

        this.pickUpdate = pickUpdate;
        this.dropOffDate = dropOffDate;
//        iUserRepository.save(customer);
    }

    public void setCustomerAddress(Address address) {
        addressRepository.save(address);
        customer.setAddress(address);
//        iUserRepository.save(customer);

    }

    public void setCustomerPaymentInfo(PaymentInfo paymentInfo) {
        paymentInfoRepository.save(paymentInfo);
        customer.setPaymentInfo(paymentInfo);

//       boolean isValid = paymentInfoValidator.isValid(paymentInfo);
//        iUserRepository.save(customer);
        makeReservation();
    }

    private void makeReservation() {
//        LocalDateAttributeConverter localDateAttributeConverter = new LocalDateAttributeConverter();
//        LocalDate currentDate = LocalDate.now();
//        LocalDate returnDate = currentDate.plusDays(10);

//        Date pickupdate = localDateAttributeConverter.convertToDatabaseColumn(currentDate);
//        Date dropoff = localDateAttributeConverter.convertToDatabaseColumn(returnDate);

        long days = DAYS.between(pickUpdate, dropOffDate);


        double fee = days * vehicle.getRentFee();


        iUserRepository.save(customer);

        rentRecordRepository.save(new RentRecord(vehicle, customer, pickUpdate, dropOffDate, fee));
    }

    public boolean dateVerifier(LocalDate pickUpDate, LocalDate returnDate) {
        return pickUpDate.isAfter(returnDate);
    }
}


