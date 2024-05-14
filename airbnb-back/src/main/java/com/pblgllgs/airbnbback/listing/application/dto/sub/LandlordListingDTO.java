package com.pblgllgs.airbnbback.listing.application.dto.sub;
/*
 *
 * @author pblgl
 * Created on 14-05-2024
 *
 */

import jakarta.validation.constraints.NotNull;

public record LandlordListingDTO(
        @NotNull String firstname,
        @NotNull String imageUrl
) {
}
