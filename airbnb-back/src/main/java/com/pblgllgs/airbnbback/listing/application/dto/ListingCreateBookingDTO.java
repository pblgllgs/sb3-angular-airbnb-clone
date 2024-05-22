package com.pblgllgs.airbnbback.listing.application.dto;
/*
 *
 * @author pblgl
 * Created on 22-05-2024
 *
 */

import com.pblgllgs.airbnbback.listing.application.dto.vo.PriceVO;

import java.util.UUID;

public record ListingCreateBookingDTO(
        UUID listingPublicId, PriceVO price) {
}
