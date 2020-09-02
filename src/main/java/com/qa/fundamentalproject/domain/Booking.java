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
    private Long dateBooked;

    @Column
    private Long totalPrice;


    @OneToOne(targetEntity = Customers.class)
    private Customers customers;


    public Booking() {
    }

    public Booking(String treatment,Long dateBooked, Long totalPrice) {
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

    public Long getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Long dateBooked) {
        this.dateBooked = dateBooked;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
}
