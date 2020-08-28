package com.qa.fundamentalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long dateBooked;

    @Column
    private Long total;

    public Booking() {
    }

    public Booking(Long dateBooked, Long total) {
        this.dateBooked = dateBooked;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Long dateBooked) {
        this.dateBooked = dateBooked;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
