package edu.mum.cs.swe.finalProject.RentCar.model.user;

import javax.persistence.*;

@Entity
public class Admin extends User {
    @OneToOne
    @JoinColumn(name = "credential_id")
    protected Credential credential;

    public Admin(String fullName, Address address, Credential credential) {
        super(fullName, address);
        this.credential = credential;
    }

    public Admin() {
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
