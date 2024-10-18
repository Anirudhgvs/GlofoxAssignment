package com.Assignment.Service;

import com.Assignment.Entity.Booking;
import com.Assignment.Entity.Classes;
import com.Assignment.Repository.BookingRepo;
import com.Assignment.Repository.ClassesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

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

    public ResponseEntity<Booking> addBookings(String memberName, String className, String date) throws Exception {
        Classes classes = classesRepo.findByClassName(className);
        if(classes == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, className + " class doesn't exist");
        }
        Booking booking = new Booking(null, memberName, date);
        booking = bookingRepo.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
