package com.pblgllgs.airbnbback.booking.repository;

import com.pblgllgs.airbnbback.booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
