package com.Assignment.Service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.Assignment.Entity.Booking;
import com.Assignment.Entity.Class;
import com.Assignment.Repository.BookingRepo;
import com.Assignment.Repository.ClassesRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public class ServiceTest {

    @Mock
    private ClassesRepo classesRepo;

    @Mock
    private BookingRepo bookingRepo;

    @InjectMocks
    private Service service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddClasses_Success() {
        // Arrange
        Class aClass = new Class(null, "Yoga", "2024-10-01", "2024-10-30", 20);
        when(classesRepo.save(any(Class.class))).thenReturn(aClass);

        // Act
        Class response = service.addClass("Yoga", "2024-10-01", "2024-10-30", 20);

        // Assert
        assertNotNull(response);
        assertEquals("Yoga", response.getClassName());
        verify(classesRepo, times(1)).save(any(Class.class));
    }

    @Test
    public void testAddBookings_Success() throws Exception {
        // Arrange
        Class yogaClass = new Class(1, "Yoga", "2024-10-01", "2024-10-30", 20);
        when(classesRepo.findByClassName("Yoga")).thenReturn(yogaClass);

        Booking booking = new Booking(null, "John Doe", "2024-10-10");
        when(bookingRepo.save(any(Booking.class))).thenReturn(booking);

        // Act
        Booking response = service.addBooking("John Doe", "Yoga", "2024-10-10");

        // Assert
        assertNotNull(response);
        assertEquals("John Doe", response.getMemberName());
        verify(bookingRepo, times(1)).save(any(Booking.class));
        verify(classesRepo, times(1)).findByClassName("Yoga");
    }

    @Test
    public void testAddBookings_ClassDoesNotExist() {
        // Arrange
        when(classesRepo.findByClassName("NonExistentClass")).thenReturn(null);

        // Act & Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            service.addBooking("John Doe", "NonExistentClass", "2024-10-10");
        });

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertEquals("NonExistentClass class doesn't exist", exception.getReason());
        verify(classesRepo, times(1)).findByClassName("NonExistentClass");
        verify(bookingRepo, times(0)).save(any(Booking.class));
    }
}
