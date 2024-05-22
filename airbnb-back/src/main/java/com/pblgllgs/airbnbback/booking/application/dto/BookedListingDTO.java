package com.pblgllgs.airbnbback.booking.application.dto;
/*
 *
 * @author pblgl
 * Created on 22-05-2024
 *
 */

import com.pblgllgs.airbnbback.listing.application.dto.sub.PictureDTO;
import com.pblgllgs.airbnbback.listing.application.dto.vo.PriceVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record BookedListingDTO(@Valid PictureDTO cover,
                               @NotEmpty String location,
                               @Valid BookedDateDTO dates,
                               @Valid PriceVO totalPrice,
                               @NotNull UUID bookingPublicId,
                               @NotNull UUID listingPublicId) {
}
