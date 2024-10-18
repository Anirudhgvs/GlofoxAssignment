package com.Assignment.Controller;

import com.Assignment.DTO.BookingRequest;
import com.Assignment.DTO.ClassRequest;
import com.Assignment.Service.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/classes")
    public ResponseEntity<?> addClasses(@Valid @RequestBody ClassRequest classRequest) {
        try {
            return service.addClasses(classRequest.getClassName(), classRequest.getStartDate(), classRequest.getEndDate(), classRequest.getCapacity());
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> addBookings(@Valid @RequestBody BookingRequest bookingRequest) {
        try {
            return service.addBookings(bookingRequest.getMemberName(), bookingRequest.getClassName(), bookingRequest.getDate());
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }



}
