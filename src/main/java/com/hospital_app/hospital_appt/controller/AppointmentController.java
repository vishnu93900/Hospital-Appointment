package com.hospital_app.hospital_appt.controller;

import com.hospital_app.hospital_appt.ExceptionHandeling.ResourceNotFoundException;
import com.hospital_app.hospital_appt.Notification.NotificationService;
import com.hospital_app.hospital_appt.model.Appointment;
import com.hospital_app.hospital_appt.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private NotificationService notificationService;


    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment, @RequestParam Long patientId) throws ResourceNotFoundException {
        Appointment createdAppointment = appointmentService.createAppointment(appointment, patientId);
        notificationService.sendAppointmentConfirmation(createdAppointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }

    @GetMapping
    public List<Appointment> getAllapp(){
        List<Appointment> appointments= appointmentService.getAllAppointments();
        notificationService.sendAppointmentConfirmation((Appointment) appointments);
        return  appointments;


    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        try {
            Appointment appointment = appointmentService.updateAppointment(id, updatedAppointment);
            notificationService.sendAppointmentConfirmation((appointment));
            return ResponseEntity.ok(appointment);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

}
