package com.qa.fundamentalproject.dto;


public class BookingDTO {

    private Long id;
    private String treatment;
    private float totalPrice;


    public BookingDTO() {
    }

    public BookingDTO(String treatment, float totalPrice) {
        this.treatment = treatment;
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


    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }


}
