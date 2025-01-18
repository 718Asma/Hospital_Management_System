package com.example.demo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Doctor")
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String cin;
    private String firstName;
    private String lastName;
    private String speciality;
    private String email;
    private String phone;
    private String address;

    public Doctor() {
    }

    public Doctor(String cin, String firstName, String lastName, String speciality, String email, String phone,
            String address) {
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Doctor [firstName=" + firstName + ", lastName=" + lastName + ", speciality=" + speciality
                + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
    }
}