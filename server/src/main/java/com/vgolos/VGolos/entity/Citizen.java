package com.vgolos.VGolos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "citizens")
public class Citizen extends Account {
    @Column(nullable = false, length = 30)
    private String firstName;
    @Column(nullable = false, length = 35)
    private String lastName;
    @Column
    private String fathersName;
    @Column(nullable = false)
    private Date dateOfBirth;
    @Column(unique = true, nullable = false)
    private Long idn;
    @Column(nullable = false)
    private String region;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getIdn() {
        return idn;
    }

    public void setIdn(Long idn) {
        this.idn = idn;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean isCitizen() {
        return true;
    }
}
