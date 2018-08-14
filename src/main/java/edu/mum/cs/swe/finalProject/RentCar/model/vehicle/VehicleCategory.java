package edu.mum.cs.swe.finalProject.RentCar.model.vehicle;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String name;
    private String description;
    private String catImg_url;

    @OneToMany(mappedBy = "category")
    private List<Vehicle> vehicleList;

    public VehicleCategory(String name, String description, String catImg_url) {
        this.name = name;
        this.description = description;
        this.catImg_url = catImg_url;
    }

    public VehicleCategory() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public void addVehicle(Vehicle vehcile) {
        this.vehicleList.add(vehcile);

    }

    public void setCatImg_url(String catImg_url) {
        this.catImg_url = catImg_url;
    }

    public String getCatImg_url() {
        return catImg_url;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
