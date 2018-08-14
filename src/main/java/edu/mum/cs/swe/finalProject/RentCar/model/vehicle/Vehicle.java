package edu.mum.cs.swe.finalProject.RentCar.model.vehicle;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotNull
//    @Min(value = 4,message = "please enter a valid model")
    private String model;
//    @NotNull
//    @Min(value = 1,message = "please enter a valid Make")
    private String make;
    @NotNull
    @Min(value = 4,message = "please enter a valid Manufacture Year")
    private String year;
//    @NotNull
//    @Min(value = 1,message = "please enter a valid url")
    private String url;
    private boolean available=true;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCategory category;
    private String description;
    private double rentFee;



    public Vehicle(String model, String make, String year,String url, String description, Double rentFee) {
        this.model = model;
        this.make = make;
        this.year = year;
         this.description = description;
        this.url=url;
        this.rentFee=rentFee;
    }

    public Vehicle() {
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VehicleCategory getCategory() {
        return category;
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
        category.addVehicle(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRentFee(Double rentFee) {
        this.rentFee = rentFee;
    }

    public Double getRentFee() {
        return rentFee;
    }
}
