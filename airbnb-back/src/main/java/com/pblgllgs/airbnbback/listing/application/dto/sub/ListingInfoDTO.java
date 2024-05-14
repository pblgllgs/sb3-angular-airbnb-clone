package com.pblgllgs.airbnbback.listing.application.dto.sub;
/*
 *
 * @author pblgl
 * Created on 14-05-2024
 *
 */

import com.pblgllgs.airbnbback.listing.application.dto.vo.BathsVO;
import com.pblgllgs.airbnbback.listing.application.dto.vo.BedroomsVO;
import com.pblgllgs.airbnbback.listing.application.dto.vo.BedsVO;
import com.pblgllgs.airbnbback.listing.application.dto.vo.GuestsVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ListingInfoDTO(
        @NotNull @Valid GuestsVO guests,
        @NotNull @Valid BedroomsVO bedrooms,
        @NotNull @Valid BedsVO beds,
        @NotNull @Valid BathsVO baths
        ) {
}
