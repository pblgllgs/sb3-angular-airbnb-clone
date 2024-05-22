package com.pblgllgs.airbnbback.listing.application.dto;
/*
 *
 * @author pblgl
 * Created on 22-05-2024
 *
 */

import com.pblgllgs.airbnbback.booking.application.dto.BookedDateDTO;
import com.pblgllgs.airbnbback.listing.application.dto.sub.ListingInfoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record SearchDTO(@Valid BookedDateDTO dates,
                        @Valid ListingInfoDTO infos,
                        @NotEmpty String location) {
}
