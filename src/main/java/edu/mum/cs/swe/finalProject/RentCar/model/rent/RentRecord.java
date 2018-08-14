package edu.mum.cs.swe.finalProject.RentCar.model.rent;


import javax.persistence.*;

import edu.mum.cs.swe.finalProject.RentCar.model.user.Customer;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;

import java.time.LocalDate;

@Entity
public class RentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private double fee;
    @ManyToOne
    @JoinColumn(name = "promo_id")
    private Promo promo;
    private double latefee;
    private double totalfee;

    private boolean paid;


    public RentRecord(Vehicle vehicle, Customer customer, LocalDate rentDate, LocalDate returnDate, double fee) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.fee = fee;

    }

    public RentRecord() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public double getLatefee() {
        return latefee;
    }

    public void setLatefee(double latefee) {
        this.latefee = latefee;
    }

    public double getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(double totalfee) {
        this.totalfee = totalfee;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
