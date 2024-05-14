package com.pblgllgs.airbnbback.listing.application.dto;
/*
 *
 * @author pblgl
 * Created on 14-05-2024
 *
 */

import com.pblgllgs.airbnbback.listing.application.dto.sub.DescriptionDTO;
import com.pblgllgs.airbnbback.listing.application.dto.sub.ListingInfoDTO;
import com.pblgllgs.airbnbback.listing.application.dto.sub.PictureDTO;
import com.pblgllgs.airbnbback.listing.application.dto.vo.PriceVO;
import com.pblgllgs.airbnbback.listing.domain.BookingCategory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SaveListingDTO {

    @NotNull
    BookingCategory category;

    @NotNull String location;

    @NotNull @Valid
    ListingInfoDTO infos;

    @NotNull @Valid
    DescriptionDTO description;

    @NotNull @Valid
    PriceVO price;

    @NotNull
    List<PictureDTO> pictures;

    public @NotNull BookingCategory getCategory() {
        return category;
    }

    public void setCategory(@NotNull BookingCategory category) {
        this.category = category;
    }

    public @NotNull String getLocation() {
        return location;
    }

    public void setLocation(@NotNull String location) {
        this.location = location;
    }

    public @NotNull @Valid ListingInfoDTO getInfos() {
        return infos;
    }

    public void setInfos(@NotNull @Valid ListingInfoDTO infos) {
        this.infos = infos;
    }

    public @NotNull @Valid DescriptionDTO getDescription() {
        return description;
    }

    public void setDescription(@NotNull @Valid DescriptionDTO description) {
        this.description = description;
    }

    public @NotNull @Valid PriceVO getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Valid PriceVO price) {
        this.price = price;
    }

    public @NotNull List<PictureDTO> getPictures() {
        return pictures;
    }

    public void setPictures(@NotNull List<PictureDTO> pictures) {
        this.pictures = pictures;
    }
}
