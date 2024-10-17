package com.Assignment.repo;

import com.Assignment.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo  extends JpaRepository<Booking,Integer> {
}
