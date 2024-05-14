package com.pblgllgs.airbnbback.listing.mapper;

import com.pblgllgs.airbnbback.listing.application.dto.sub.CreatedListingDTO;
import com.pblgllgs.airbnbback.listing.application.dto.SaveListingDTO;
import com.pblgllgs.airbnbback.listing.domain.Listing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ListingPictureMapper.class})
public interface ListingMapper {

    @Mapping(target = "landlordPublicId", ignore = true)
    @Mapping(target = "publicId", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "pictures", ignore = true)
    @Mapping(target = "title", source = "description.title.value")
    @Mapping(target = "description", source = "description.description.value")
    @Mapping(target = "bedrooms", source = "infos.bedrooms.value")
    @Mapping(target = "guests", source = "infos.guests.value")
    @Mapping(target = "bookingCategory", source = "category")
    @Mapping(target = "beds", source = "infos.beds.value")
    @Mapping(target = "bathrooms", source = "infos.baths.value")
    @Mapping(target = "price", source = "price.value")
    Listing saveListingDTOToListing(SaveListingDTO saveListingDTO);

    CreatedListingDTO listingToCreatedListingDTO(Listing listing);
}
