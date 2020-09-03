package com.qa.fundamentalproject.dto;


import java.util.ArrayList;
import java.util.List;

public class BookingDTO {

    private Long bookingId;
    private String treatment;
    private float totalPrice;
    private List<CustomersDTO> customers =  new ArrayList<>();


    public BookingDTO() {
    }

    public BookingDTO(String treatment, float totalPrice) {
        this.treatment = treatment;
        this.totalPrice = totalPrice;

    }

    public Long getId() {
        return bookingId;
    }

    public void setId(Long id) {
        this.bookingId = id;
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

    public List<CustomersDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomersDTO> customers) {
        this.customers = customers;
    }
}
