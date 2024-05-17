package com.pblgllgs.airbnbback.listing.application.dto;
/*
 *
 * @author pblgl
 * Created on 17-05-2024
 *
 */

import com.pblgllgs.airbnbback.listing.application.dto.sub.PictureDTO;
import com.pblgllgs.airbnbback.listing.application.dto.vo.PriceVO;
import com.pblgllgs.airbnbback.listing.domain.BookingCategory;

import java.util.UUID;

public record DisplayCardListingDTO(PriceVO price,
                                    String location,
                                    PictureDTO cover,
                                    BookingCategory bookingCategory,
                                    UUID publicId) {
}
