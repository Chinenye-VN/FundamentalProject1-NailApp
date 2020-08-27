package com.qa.fundamentalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nailology {
    @Id
    @GeneratedValue
    private Long id;
}
