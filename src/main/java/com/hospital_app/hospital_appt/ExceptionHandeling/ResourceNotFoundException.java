package com.hospital_app.hospital_appt.ExceptionHandeling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends Exception{
    public  ResourceNotFoundException(String message){
        super(message);

    }
}
