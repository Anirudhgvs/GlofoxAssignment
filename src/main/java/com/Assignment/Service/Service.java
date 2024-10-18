package com.Assignment.Service;

import com.Assignment.Entity.Booking;
import com.Assignment.Entity.Class;
import com.Assignment.Repository.BookingRepo;
import com.Assignment.Repository.ClassesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ClassesRepo classesRepo;

    @Autowired
    private BookingRepo bookingRepo;

    public Class addClass(String className, String startDate, String endDate, Integer capacity) {
        Class newClass = new Class(null, className, startDate, endDate, capacity);
        return classesRepo.save(newClass);
    }

    public Booking addBooking(String memberName, String className, String date) throws Exception {
        Class existingClass = classesRepo.findByClassName(className);
        if(existingClass == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, className + " class doesn't exist");
        }
        Booking booking = new Booking(null, memberName, date);
        return bookingRepo.save(booking);
    }
}
