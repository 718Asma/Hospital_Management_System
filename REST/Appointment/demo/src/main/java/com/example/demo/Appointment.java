package com.example.demo;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Appointments")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private ObjectId idMed;
    private ObjectId idPat;
    private String appointmentDate;
    private String status; // e.g., Scheduled, Cancelled, Completed

    public Appointment() {
    }

    public Appointment(ObjectId idMed, ObjectId idPat, String appointmentDate, String status) {
        this.idMed = idMed;
        this.idPat = idPat;
        this.appointmentDate = appointmentDate;
        this.status = status;
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

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", cinMed='" + idMed + '\'' +
                ", cinPat='" + idPat + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", status='" + status + '\'' +
                '}';
    }
}