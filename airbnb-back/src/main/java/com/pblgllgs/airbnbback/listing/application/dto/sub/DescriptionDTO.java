package com.pblgllgs.airbnbback.listing.application.dto.sub;
/*
 *
 * @author pblgl
 * Created on 14-05-2024
 *
 */

import com.pblgllgs.airbnbback.listing.application.dto.vo.DescriptionVO;
import com.pblgllgs.airbnbback.listing.application.dto.vo.TitleVO;
import jakarta.validation.constraints.NotNull;

public record DescriptionDTO(
        @NotNull TitleVO title,
        @NotNull DescriptionVO description
        ) {
}
