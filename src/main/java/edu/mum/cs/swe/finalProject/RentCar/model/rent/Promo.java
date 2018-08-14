package edu.mum.cs.swe.finalProject.RentCar.model.rent;

import javax.persistence.*;
import java.util.List;
@Entity
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String code;
    private double value;

    @OneToMany(mappedBy = "customer")
    private List<RentRecord> rentrecord;

    public Promo(String code, double value) {
        this.code = code;
        this.value = value;
    }

    public Promo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<RentRecord> getRentrecord() {
        return rentrecord;
    }

    public void setRentrecord(List<RentRecord> rentrecord) {
        this.rentrecord = rentrecord;
    }
    public void addRentRecord(RentRecord rentrecord) {
        this.rentrecord.add(rentrecord);
        rentrecord.setPromo(this);
    }
}
