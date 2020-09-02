package com.qa.fundamentalproject.dto;


public class BookingDTO {

    private Long id;
    private String treatment;
    private String dateBooked;
    private float totalPrice;
    private CustomersDTO customersDTO;


    public BookingDTO() {
    }

    public BookingDTO(String treatment, String dateBooked, float totalPrice) {
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

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomersDTO getCustomersDTO() {
        return customersDTO;
    }

    public void setCustomersDTO(CustomersDTO customersDTO) {
        this.customersDTO = customersDTO;
    }
}
