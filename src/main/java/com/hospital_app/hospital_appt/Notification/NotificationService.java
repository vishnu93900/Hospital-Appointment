package com.hospital_app.hospital_appt.Notification;

import com.hospital_app.hospital_appt.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Async
    public void sendAppointmentConfirmation(Appointment appointment) {
        logger.info("Starting asynchronous task: Sending appointment confirmation for appointment ID: {}", appointment.getAppointmentId());
        // Simulate a long-running task (e.g., email sending, external API call)
        try {
            Thread.sleep(5000); // Simulate 5 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Task interrupted: ", e);
        }
        logger.info("Asynchronous task completed: Appointment confirmation sent for appointment ID: {}", appointment.getAppointmentId());
    }
}