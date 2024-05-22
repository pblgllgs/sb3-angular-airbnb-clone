package com.pblgllgs.airbnbback.booking.application.dto;
/*
 *
 * @author pblgl
 * Created on 22-05-2024
 *
 */

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

public record NewBookingDTO(
        @NotNull OffsetDateTime startDate,
        @NotNull OffsetDateTime endDate,
        @NotNull UUID listingPublicId) {
}
