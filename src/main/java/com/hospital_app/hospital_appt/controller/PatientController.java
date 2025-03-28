package com.hospital_app.hospital_appt.controller;

import com.hospital_app.hospital_appt.ExceptionHandeling.ResourceNotFoundException;
import com.hospital_app.hospital_appt.model.Patient;
import com.hospital_app.hospital_appt.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        Patient newPatient = patientService.createPatient(patient);
        return  new ResponseEntity<>(newPatient, HttpStatus.CREATED);

    }
    @GetMapping("/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable Long patientId) throws ResourceNotFoundException {
        try {
            Patient patient = patientService.getPatientById(patientId);
            return ResponseEntity.ok(patient);
        } catch (ResourceNotFoundException e) {
            String errorMessage = "Patient not found with id " + patientId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
    @PutMapping("{patientId}")
    public ResponseEntity<?> UpdatePatientById(@PathVariable Long patientId , @RequestBody Patient updatingPatient) throws ResourceNotFoundException {
        try {
            Patient patient = patientService.updatePatient(patientId ,updatingPatient);
            return ResponseEntity.ok(patient);
        } catch (ResourceNotFoundException e) {
            String errorMessage = "Patient not found with id " + patientId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

}
