package com.hospital_app.hospital_appt.service;

import com.hospital_app.hospital_appt.ExceptionHandeling.ResourceNotFoundException;
import com.hospital_app.hospital_appt.Repository.PatientRepository;
import com.hospital_app.hospital_appt.model.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.*;

import java.util.Optional;
@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);



    @Autowired
    private PatientRepository patientRepository;
    @Operation(summary = "Create a new patient",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Patient created successfully",
                            content = @Content(schema = @Schema(implementation = Patient.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            })

    public Patient createPatient(Patient patient){
        logger.info("entery to the CreatePatient()..!");
        return patientRepository.save(patient);


    }


    public Patient getPatientById(Long id) throws ResourceNotFoundException{
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
    }

    public Patient updatePatient(Long id, Patient updatedPatient)  throws  ResourceNotFoundException{
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setDateOfBirth(updatedPatient.getDateOfBirth());
                    patient.setContactNumber(updatedPatient.getContactNumber());
                    return patientRepository.save(patient);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
    }
    public void deletePatient(Long patientid) throws  ResourceNotFoundException{
            Optional<Patient> existingPatient = patientRepository.findById(patientid);
            if (existingPatient.isPresent()) {
                patientRepository.deleteById(patientid);
            } else {
                throw new ResourceNotFoundException("Patient not found with id " + patientid);
            }
        }



        public List<Patient> getAllPatients(){
         return patientRepository.findAll();
        }


}
