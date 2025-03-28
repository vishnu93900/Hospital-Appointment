package com.hospital_app.hospital_appt.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AppointmentId;
    private LocalDateTime appointmentDateTime;
    private String reasonForVisit;
    private String status;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonBackReference // To prevent infinite recursion during serialization
    private Patient patient; 

    public Appointment(){

    }

    public Appointment(Long appointmentId, LocalDateTime appointmentDateTime, String reasonForVisit, String status ,Patient patient) {
        AppointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.reasonForVisit = reasonForVisit;
        this.status = status;
        this.patient=patient;
    }

    public Long getAppointmentId() {
        return AppointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        AppointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
