package com.pblgllgs.airbnbback.booking.mapper;

import com.pblgllgs.airbnbback.booking.application.dto.BookedDateDTO;
import com.pblgllgs.airbnbback.booking.application.dto.NewBookingDTO;
import com.pblgllgs.airbnbback.booking.domain.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking newBookingToBooking(NewBookingDTO newBookingDTO);

    BookedDateDTO bookingToCheckAvailability(Booking booking);
}
