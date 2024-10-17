package com.Assignment.service;

import com.Assignment.entity.Booking;
import com.Assignment.entity.Classes;
import com.Assignment.repo.BookingRepo;
import com.Assignment.repo.ClassesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ClassesRepo classesRepo;

    @Autowired
    private BookingRepo bookingRepo;

    public ResponseEntity<Classes> addClasses(String className, String startDate, String endDate, Integer capacity) {
        Classes classes = new Classes(null, className, startDate, endDate, capacity);
        classes = classesRepo.save(classes);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    public ResponseEntity<Booking> addBooking(String memberName, String className, String date) throws Exception {
        Classes classes = classesRepo.findByClassName(className);
        if(classes == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, className + " class doesn't exist");
        }
        Booking booking = new Booking(null, memberName, date);
        booking = bookingRepo.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
