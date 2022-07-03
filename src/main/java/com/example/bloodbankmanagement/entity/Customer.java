package com.example.bloodbankmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;


    private String fname;


    private String lname;


    private String ssn;


    @Email
    private String email;
    @Enumerated(EnumType.STRING)

    private BloodType bloodType;

    @Enumerated(EnumType.STRING)

    private Role role;

    public Customer() {

    }

    public Customer(String fname, String lname, String ssn, String email, BloodType bloodType, Role role) {
        this.fname = fname;
        this.lname = lname;
        this.ssn = ssn;
        this.email = email;
        this.bloodType = bloodType;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
