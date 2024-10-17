package com.Assignment.controller;

import com.Assignment.service.Service;
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
    public ResponseEntity<?> addClasses(
            @RequestParam(value = "className", required = false) String className,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "capacity", required = false, defaultValue = "10") Integer capacity) {
        try {
            return service.addClasses(className, startDate, endDate, capacity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> addBooking(
            @RequestParam(value = "memberName", required = false) String memberName,
            @RequestParam(value = "className", required = false) String className,
            @RequestParam(value = "date", required = false) String date) {
        try {
            return service.addBooking(memberName, className, date);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }



}
