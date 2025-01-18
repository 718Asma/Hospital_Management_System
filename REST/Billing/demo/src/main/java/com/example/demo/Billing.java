package com.example.demo;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Billing")
public class Billing implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private ObjectId idMed;
    private ObjectId idPat;
    private ObjectId idPharmacy;
    private String date;
    private String amount;

    public Billing() {
    }

    public Billing(ObjectId idMed, ObjectId idPat, ObjectId idPharmacy, String date, String amount) {
        this.idMed = idMed;
        this.idPat = idPat;
        this.idPharmacy = idPharmacy;
        this.date = date;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectId getIdMed() {
        return idMed;
    }

    public void setIdMed(ObjectId idMed) {
        this.idMed = idMed;
    }

    public ObjectId getIdPat() {
        return idPat;
    }

    public void setIdPat(ObjectId idPat) {
        this.idPat = idPat;
    }

    public ObjectId IdPharmacy() {
        return idPharmacy;
    }

    public void IdPharmacy(ObjectId idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill [date=" + date + ", amount=" + amount + "]";
    }

}
