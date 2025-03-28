package com.hospital_app.hospital_appt.service;

import com.hospital_app.hospital_appt.ExceptionHandeling.ResourceNotFoundException;
import com.hospital_app.hospital_appt.Repository.PatientRepository;
import com.hospital_app.hospital_appt.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient){
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
