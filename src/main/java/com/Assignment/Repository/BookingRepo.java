package com.Assignment.Repository;

import com.Assignment.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo  extends JpaRepository<Booking,Integer> {
}
