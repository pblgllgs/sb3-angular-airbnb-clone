package com.pblgllgs.airbnbback.listing.application.dto.vo;
/*
 *
 * @author pblgl
 * Created on 14-05-2024
 *
 */

import jakarta.validation.constraints.NotNull;

public record GuestsVO(
        @NotNull(message = "Guests value must be present")
        int value
) {
}
