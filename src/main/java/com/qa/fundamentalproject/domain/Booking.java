package com.qa.fundamentalproject.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long bookingid;

    @Column
    private String treatment;

    @Column
    private float totalPrice;

    @OneToMany(mappedBy = "booking", fetch = FetchType.EAGER)
    private List<Customers> customers = new ArrayList<>();




    public Booking() {
    }

    public Booking(String treatment, float totalPrice) {
        this.treatment = treatment;
        this.totalPrice = totalPrice;

    }

    public Long getId() {
        return bookingid;
    }

    public void setId(Long id) {
        this.bookingid = id;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }


    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
}
