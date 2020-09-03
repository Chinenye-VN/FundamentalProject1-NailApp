package com.qa.fundamentalproject.dto;


public class BookingDTO {

    private Long bookingid;
    private String treatment;
    private float totalPrice;


    public BookingDTO() {
    }

    public BookingDTO(String treatment, float totalPrice) {
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


}
