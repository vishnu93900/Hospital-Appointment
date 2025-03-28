package com.hospital_app.hospital_appt.Repository;


import com.hospital_app.hospital_appt.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepositry  extends JpaRepository<Appointment ,Long> {

}
