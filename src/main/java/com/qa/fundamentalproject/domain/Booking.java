package com.qa.fundamentalproject.domain;
import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String treatment;

    @Column
    private float dateBooked;

    @Column
    private float totalPrice;


    @OneToOne(targetEntity = Customers.class)
    private Customers customers;


    public Booking() {
    }

    public Booking(String treatment, float dateBooked, float totalPrice) {
        this.treatment = treatment;
        this.dateBooked = dateBooked;
        this.totalPrice = totalPrice;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public float getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(float dateBooked) {
        this.dateBooked = dateBooked;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

}
