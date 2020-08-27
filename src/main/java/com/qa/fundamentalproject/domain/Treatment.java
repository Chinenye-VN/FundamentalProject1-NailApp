package com.qa.fundamentalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Treatment {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nailSet;

    @Column
    private Long timeTaken;

    @Column
    private Long price;


    public Treatment() {
    }

    public Treatment(String nailSet, Long timeTaken, Long price) {
        this.nailSet = nailSet;
        this.timeTaken = timeTaken;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNailSet() {
        return nailSet;
    }

    public void setNailSet(String nailSet) {
        this.nailSet = nailSet;
    }

    public Long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
