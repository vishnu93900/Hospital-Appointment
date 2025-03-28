package com.hospital_app.hospital_appt.service;


import com.hospital_app.hospital_appt.ExceptionHandeling.ResourceNotFoundException;
import com.hospital_app.hospital_appt.Repository.AppointmentRepositry;
import com.hospital_app.hospital_appt.Repository.PatientRepository;
import com.hospital_app.hospital_appt.model.Appointment;
import com.hospital_app.hospital_appt.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentRepositry appointmentRepositry;

    public List<Appointment> getAllAppointments() {
        return appointmentRepositry.findAll();
    }


    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepositry.findById(id);
    }


    public Appointment createAppointment(Appointment appointment, Long patientId) throws ResourceNotFoundException {
        try {
            Patient patient = patientService.getPatientById(patientId);
            appointment.setPatient(patient);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Patient not found with id " + patientId);

        }
        return appointmentRepositry.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) throws ResourceNotFoundException {
        return appointmentRepositry.findById(id)
                .map(appointment -> {
                    appointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
                    appointment.setReasonForVisit(updatedAppointment.getReasonForVisit());
                    appointment.setStatus(updatedAppointment.getStatus());
                    appointment.setPatient(updatedAppointment.getPatient());
                    return appointmentRepositry.save(appointment);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
    }
    public void deleteAppointment(Long apptid) throws  ResourceNotFoundException{
        Optional<Appointment> existingPatient = appointmentRepositry.findById(apptid);
        if (existingPatient.isPresent()) {
            appointmentRepositry.deleteById(apptid);
        } else {
            throw new ResourceNotFoundException("Patient not found with id " + apptid);
        }
    }


}
